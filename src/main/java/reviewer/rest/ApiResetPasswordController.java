package reviewer.rest;



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
import reviewer.service.TokenService;

@Controller
@RequestMapping("/api/resetpassword")
public class ApiResetPasswordController 

{
	private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;

    public ApiResetPasswordController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

	
	
	@GetMapping("/resetpassword")
	    public String resetpassword(@RequestParam String token,Model model) {
		//User user = tokenService.isValidToken(user, token);
		 User user = tokenService.getUserByToken(token);

		    if (user != null) {
		    	System.out.println(user.getEmailId());
		        model.addAttribute("user",user);
		        return "success";
		    } else {
		        System.out.println("Invalid token or user not found");
		        return "error";
		    }
	    }
	 
	@PostMapping("/resetpassword")
    public String resetpasswordimpl(@ModelAttribute User user,@RequestParam("newpassword") String password) 
	{
		//System.out.println("user0"+user.toString());
		User user0;
		user0= userRepository.findByEmailId(user.getEmailId());
		System.out.println("user1"+user0.toString());
		if(user0!=null) 
		{
		user0.setPassword(passwordEncoder.encode(password));
        userRepository.save(user0);
		return "success";
		}
		return "error";
		
    }

	
	
}


