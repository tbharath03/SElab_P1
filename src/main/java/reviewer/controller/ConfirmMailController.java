
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
import reviewer.service.TokenService;

@Controller
@RequestMapping("/")
public class ConfirmMailController 

{
	private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;

    public ConfirmMailController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

	
	
	@GetMapping("/ConfirmRegister")
	    public String resetpassword(@RequestParam String token,Model model) {
		//User user = tokenService.isValidToken(user, token);
		 User user = tokenService.getUserByToken(token);

		    if (user != null) {
		    	System.out.println(user.getEmailId());
		        model.addAttribute("user",user);
		        return "ConfirmRegister";
		    } else {
		        System.out.println("Invalid token or user not found");
		        return "error";
		    }
	    }
	 
	@PostMapping("/ConfirmRegister")
    public String resetpasswordimpl(@ModelAttribute User user) 
	{
		System.out.println(user.getEmailId());
		User user0;
		user0= userRepository.findByEmailId(user.getEmailId());
		System.out.println("user1"+user0.toString());
		if(user0!=null) 
		{
		//user0.setPassword(passwordEncoder.encode(password));
			System.out.println("im setting here");
		user0.setConfirm(1L);
		System.out.println(user.toString());
        userRepository.save(user0);
		return "redirect:/login?success";
		}
		
		System.out.println("here");
		return "error";
		
    }

	
	
}


