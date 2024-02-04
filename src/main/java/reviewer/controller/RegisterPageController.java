package reviewer.controller;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import reviewer.model.User;
import reviewer.repository.UserRepository;

@Controller
@RequestMapping("/registerPage")
public class RegisterPageController {
     private UserRepository userRepo;
     private PasswordEncoder passwordEncoder;
     
     public RegisterPageController(UserRepository userRepo,PasswordEncoder passwordEncoder) {
    	    this.userRepo =userRepo;
    	    this.passwordEncoder=passwordEncoder;
     }
     
     @ModelAttribute
     public User user()
     {
    	 return new User();
     }
	@GetMapping
	public String registerpage(Model model) {
		
		User user = new User();
// enters into this class after entering the enter button
//		System.out.println("getmethod");
		model.addAttribute("user",user);
		return "registerPage";
	}
	
	@PostMapping
	public String registerationprocess(@ModelAttribute User user){
		System.out.println(user.toString());
		User user0;
		user0= userRepo.findByEmailId(user.getEmailId());
		if(user0==null) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
		return "redirect:/registerPage?success";
		}else {
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
		}
	}
}