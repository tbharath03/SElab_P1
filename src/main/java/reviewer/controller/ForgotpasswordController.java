
package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reviewer.model.User;
import reviewer.repository.UserRepository;
import reviewer.service.EmailService;
import reviewer.service.TokenService;

@Controller
@RequestMapping("/")
public class ForgotpasswordController 

{
   
	 private UserRepository userRepository;
	  private TokenService tokenService;
private EmailService emailservice;
	    public ForgotpasswordController(UserRepository userRepository, TokenService tokenService,EmailService emailservice) {
	        this.userRepository = userRepository;
	        this.tokenService = tokenService;
	        this.emailservice=emailservice;
	    }

	    @GetMapping("/forgotpassword")
	    public String forgotdisplay() {
	        return "forgotpassword";
	    }
	 
	@PostMapping("/forgotpassword")
	public void forgotimpl(@RequestParam String email,@RequestParam String number)
	{
		User user=userRepository.findByEmailId(email);
		System.out.println(number);
		System.out.println(user.getNumber());
		if(user!=null && number.equals(user.getNumber()))
		{
	 
			 String resetToken = tokenService.generateToken();
	            tokenService.saveToken(user, resetToken);
	            System.out.println("before mail service");
	            emailservice.sendResetEmail(user.getEmailId(), resetToken);
	            System.out.println("hloo");
		}
		
	}
}

