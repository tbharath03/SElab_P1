package reviewer.controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import reviewer.model.User;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;
import reviewer.service.EmailService;
import reviewer.service.TokenService;

/**
 * Controller class for handling user login.
 *
 * This controller manages user login functionality, including password hashing for security.
 * The password provided during login will be hashed, and the hash value will be verified against
 * the stored hash in the database for authentication.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	   private UserRepository userRepo;
	     private PasswordEncoder passwordEncoder;
	     private TagRepository tagRepository;
	     private TokenService tokenService;
	     private EmailService emailservice;
	     
	     public LoginController(UserRepository userRepo,PasswordEncoder passwordEncoder, TagRepository tagRepository, TokenService tokenService, EmailService emailservice) 
	     {
	    	    this.userRepo =userRepo;
	    	    this.passwordEncoder=passwordEncoder;
	    	    this.tagRepository=tagRepository;
	    	    this.tokenService=tokenService;
	    	    this.emailservice=emailservice;
	     }
	@GetMapping
	public String login(Model model) 
	{
		User user = new User();
		model.addAttribute("user",user);
		return "login";
	}
	
	@PostMapping
	public String login1(@ModelAttribute User user) 
	{
		System.out.println(user.toString());
		User user0;
		user0= userRepo.findByEmailId(user.getEmailId());
		if(user0.getConfirm()==0)
		{
		return "login";
		}
		return "dashboard";
		
	}
	
}
