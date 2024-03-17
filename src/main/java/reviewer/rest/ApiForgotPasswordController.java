package reviewer.rest;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reviewer.model.User;
import reviewer.repository.UserRepository;
import reviewer.service.EmailService;
import reviewer.service.TokenService;

@RestController
@RequestMapping("/api/forgotpassword")
public class ApiForgotPasswordController 

{
   
	 private UserRepository userRepository;
	  private TokenService tokenService;
private EmailService emailservice;
	    public ApiForgotPasswordController(UserRepository userRepository, TokenService tokenService,EmailService emailservice) {
	        this.userRepository = userRepository;
	        this.tokenService = tokenService;
	        this.emailservice=emailservice;
	    }

	 
	@PostMapping("/forgotpassword")
	public String forgotimpl(@RequestParam String email,@RequestParam String number)
	{
		User user=userRepository.findByEmailId(email);
		System.out.println(number);
		System.out.println(user.getNumber());
		if(user!=null && number.equals(user.getNumber()))
		{
	 
			 String resetToken = tokenService.generateToken();
	            tokenService.saveToken(user, resetToken);
	            emailservice.sendResetEmail(user.getEmailId(), resetToken);
	          return "emailsent";
		}
		
		return "wrong credentials";
		
	}
}


