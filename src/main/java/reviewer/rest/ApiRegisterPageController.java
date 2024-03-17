package reviewer.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

import reviewer.model.Tag;
import reviewer.model.User;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
public class ApiRegisterPageController 
{
   private UserRepository userRepo;
   private PasswordEncoder passwordEncoder;
   private TagRepository tagRepository;

   public ApiRegisterPageController(UserRepository userRepo,PasswordEncoder passwordEncoder, TagRepository tagRepository) 
   {
  	    this.userRepo =userRepo;
  	    this.passwordEncoder=passwordEncoder;
  	    this.tagRepository=tagRepository;
   }
   
   @ModelAttribute
   public User user()
   {
  	 return new User();
   }
   
   
  
  
   @PostMapping("/register")
   public User registerUser(@RequestBody RegisterRequest user) 
   
   {
		System.out.println(user.toString());
		User user0;
		user0= userRepo.findByEmailId(user.getEmailId());
		User user1=new User();
		if(user0==null) 
		{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
   //  userRepo.save(user);
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
	    			
	    			user1.setEmailId(user.getEmailId());
	    			user1.setFirstName(user.getFirstName());
	    			user1.setLastName(user.getLastName());
	    			user1.setNumber(user.getNumber());
	    			user1.setPassword(user.getPassword());
	    			user1.setTag(user1.getTag());
	    		 List<User> list = new ArrayList<User>(); 
	    	        list.add(user1);
	    	        System.out.println("HLOO"+list);
	    	        System.out.println(Arrays.toString(list.toArray()));
	    		tag2.setUser(user1);
	    		tagRepository.save(tag2);
	    		
	    		mytag="";
	    	}
	    		}
	    }
	    
	    return user1;
		}
		
		else {

			   return null;
	}
   }
	
}











