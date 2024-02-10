
package reviewer.controller;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reviewer.model.User;
import reviewer.repository.UserRepository;
import reviewer.service.TokenService;

@Controller
@RequestMapping("/")
public class ResetpasswordController 

{
	private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;

    public ResetpasswordController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

	
	
	@GetMapping("/resetpassword")
	    public String resetpassword(@RequestParam String token,Model model, Principal principal) {
		//User user = tokenService.isValidToken(user, token);
		 User user = tokenService.getUserByToken(token);

		    if (user != null) {
		    	System.out.println(user.getEmailId());
		        model.addAttribute("user", user);
		        return "resetpassword";
		    } else {
		        System.out.println("Invalid token or user not found");
		        return "error";
		    }
		/* User user = tokenService.getUserByToken(token);
	        if(principal!=null)
	        {
	        	String username = principal.getName();
	        User user = userRepository.findByEmailId(username); 
	        boolean u1=tokenService.isValidToken(user, token);
	        if(u1==true)
	        {
	        model.addAttribute("user", user); 
	        System.out.println(username);
	        return "resetpassword";
	        }
	        
	        else
	        {
	        	System.out.println("invalidtoken");
	        	return "error";
	        }
	        }
	        return "home";*/
	    }
	 
	@PostMapping("/resetpassword")
    public String resetpasswordimpl(@ModelAttribute User user,@RequestParam("newPassword")String newPassword) {
    	
System.out.println(user.toString());
		System.out.println(user.getEmailId());

		if(user!=null)
		{
			System.out.println(user.getEmailId());
    	User user0 = userRepository.findByEmailId(user.getEmailId());
    	user0.setPassword(passwordEncoder.encode(newPassword));
    	userRepository.save(user0);
    	tokenService.invalidateToken(user, user.getResetToken());
    	return "login";
		}
		
			return "home";
    }

	
	
}


