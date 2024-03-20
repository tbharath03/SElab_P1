package reviewer.controller;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

////import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import reviewer.model.Tag;
import reviewer.model.User;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;
import reviewer.service.EmailService;
import reviewer.service.TokenService;
/**
 * Controller class for user registration.
 *
 * This controller handles the user registration process, including displaying the registration page,
 * providing a new User object as a model attribute, and processing the registration details.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Controller
@RequestMapping("/registerPage")
public class RegisterPageController 
{
     private UserRepository userRepo;
     private PasswordEncoder passwordEncoder;
     private TagRepository tagRepository;
     private TokenService tokenService;
     private EmailService emailservice;
     /**
      * Constructor for RegisterPageController.
      *
      * @param userRepo        The user repository.
      * @param passwordEncoder The password encoder for secure password storage.
     * @param tagRepository 
     * @param tokenService 
     * @param emailservice 
      */
     public RegisterPageController(UserRepository userRepo,PasswordEncoder passwordEncoder, TagRepository tagRepository, TokenService tokenService, EmailService emailservice) 
     {
    	    this.userRepo =userRepo;
    	    this.passwordEncoder=passwordEncoder;
    	    this.tagRepository=tagRepository;
    	    this.tokenService=tokenService;
    	    this.emailservice=emailservice;
     }
     /**
      * Provides a new User object as a model attribute.
      *
      * @return A new User object.
      */
     @ModelAttribute
     public User user()
     {
    	 return new User();
     }
     /**
      * Displays the user registration page.
      *
      * @param model The model to add attributes to the user.
      * @return The logical view name "registerPage".
      *
      * @see User For information about the User model.
      */
     @GetMapping
	public String registerpage(Model model) 
     {
		
		User user = new User();
		model.addAttribute("user",user);
		return "registerPage";
	 }
     /**
      * Handles the user registration process.
      *
      * @param user The User object containing registration details.
      * @return Redirects to the registration page with a success message or throws an exception if the email already exists.
      *
      * @see User For information about the User model.
      * @see UserRepository For information about the user repository.
      */


	@PostMapping
	public String registerationprocess(@ModelAttribute User user)
	{
		
		
		System.out.println(user.toString());
		User user0;
		user0= userRepo.findByEmailId(user.getEmailId());
		
		if(user0==null) 
		{
			
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        
	    String tags=user.getTag();
	    tags=tags+",";
	    String mytag="";
	    for(int i=0;i<tags.length();i++)
	    {
	    	if(tags.charAt(i)!=',')
	    	{
	    		mytag=mytag+tags.charAt(i);
	    	}
	    	
	    	else 
	    		{
	    		if(mytag!="")
	    		{
	    		
	    			Tag tag2=new Tag();
	    			tag2.setTag(mytag);
	    		 List<User> list = new ArrayList<User>(); 
	    	        list.add(user);
	    	        System.out.println("HLOO"+list);
	    	        System.out.println(Arrays.toString(list.toArray()));
	    		tag2.setUser(user);
	    		tagRepository.save(tag2);
	    		
	    		mytag="";
	    	}
	    		}
	    }
	    String resetToken = tokenService.generateToken();
        tokenService.saveToken(user, resetToken);
        System.out.println("before mail service");
        emailservice.sendResetEmail(user.getEmailId(), resetToken);
     //   (, resetToken);
        System.out.println("hloo");
		return "redirect:/login?success";
		}
		
		else {
			//session.setAttribute("msg","invalid email this email already exsist");
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
	}
		
}
	
}



