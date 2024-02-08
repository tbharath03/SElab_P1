package reviewer.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import reviewer.model.User;
import reviewer.repository.UserRepository;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

    private UserRepository repo;
    private PasswordEncoder passwordEncoder;

    /**
     * Constructor for EditProfileController.
     * 
     * @param repo The UserRepository for interacting with user data.
     */
    public EditProfileController(UserRepository repo,PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder=passwordEncoder;
    }

    /**
     * Handles HTTP GET requests for the edit profile page.
     * Retrieves the user details using the principal's username and adds them to the model.
     * 
     * @param model     The Spring Model object to add attributes.
     * @param principal The Principal object representing the current logged-in user.
     * @return The view name "editProfile".
     */
    @GetMapping
    public String EditProfile(Model model, Principal principal) {
        String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username); // Retrieve the user details from the repository using the username
        model.addAttribute("user", user); // Add the user details to the model
        return "editProfile"; // Return the view name for displaying the edit profile page
    }

    /**
     * Handles HTTP POST requests for submitting edited profile data.
     * Saves the updated user details to the repository.
     * 
     * @param user The User object populated with form data using @ModelAttribute.
     * @return Redirects to the "/dashboard" page after successful profile edit.
     */
    @PostMapping
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




//@RequestParam("emailId") String emailId ,
//@RequestParam("firstName") String firstName,
//@RequestParam("lastName") String lastName,
//@RequestParam("number") String number,
//@RequestParam("paperlimit") String paperlimit,
//@RequestParam("password") String password,
//@RequestParam("reEnterPassword") String reEnterPassword,
//@RequestParam("oldPassword") String oldPassword,