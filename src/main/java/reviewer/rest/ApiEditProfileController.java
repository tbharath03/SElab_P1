package reviewer.rest;
import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

@Controller
@RequestMapping(path="/api/editProfile",produces="application/json")
public class ApiEditProfileController {

    private UserRepository repo;
    private PasswordEncoder passwordEncoder;
    private PaperRepository paperRepo;
    private ReviewRepository reviewRepo;

    public ApiEditProfileController(UserRepository repo,PasswordEncoder passwordEncoder,PaperRepository paperRepo,ReviewRepository reviewRepo) {
        this.repo = repo;
        this.passwordEncoder=passwordEncoder;
        this.paperRepo = paperRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/{id}")
    public User EditProfile(@PathVariable("id") String EmailId, Principal principal) {
        User user = repo.findByEmailId(EmailId);
        System.out.println(user);
        return user; 
    }

    @PostMapping(path="/save/{id}" , consumes="application/json")
    public String Edit( @ModelAttribute User user,
    					@RequestParam("newPassword")String newPassword,
    					@RequestParam("reEnterPassword")String reEnterPassword,
    					Principal principal) {
    	
    	User user0 = repo.findByEmailId(principal.getName());
    	if(!user0.getEmailId().equals(user.getEmailId()) && user.getEmailId() != null) {
    		User user1 = repo.findByEmailId(user.getEmailId());
    		if(user1 != null) {
    			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
    		}
    		else{
    			user0.setEmailId(user.getEmailId());
    		}
    	}
    	if(user0.getFirstName() != user.getFirstName() && user.getFirstName() != null) {
    		user0.setFirstName(user.getFirstName());
    	}
    	if(user0.getLastName() != user.getLastName() && user.getLastName() != null) {
    		user0.setLastName(user.getLastName());
    	}
    	if(user0.getNumber() != user.getNumber() && user.getNumber() != null) {
    		user0.setNumber(user.getNumber());
    	}
    	if(user0.getPaperlimit() != user.getPaperlimit() && user.getPaperlimit() != null) {
    		user0.setPaperlimit(user.getPaperlimit());
    	}
    	System.out.println(newPassword);
    	System.out.println(reEnterPassword);
    	System.out.println(user.getPassword());
    	if(newPassword != "" && reEnterPassword != "" && user.getPassword() != "") {
    		if(passwordEncoder.matches(user.getPassword(),user0.getPassword())) {
    			if(newPassword.equals(reEnterPassword)) {
    				user0.setPassword(passwordEncoder.encode(newPassword));
    			}
    			else {
    				System.out.println("newpasswords didnt matched");
    				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "newpasswords didnt matched");
    			}
    		}
    		else {
    			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "old password didnt matched");
    		}
    	}
    	
    	repo.save(user0);
    	return "dashboard";
    }
}

