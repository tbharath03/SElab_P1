package reviewer.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reviewer.model.Tag;
import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;

/**
 * Controller class for handling reviews.
 *
 * This controller manages the display of the review page and handles the submission of review.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Controller
@RequestMapping("/tags")
public class TagController {
   
	
	@Autowired
	 private UserRepository userRepository;
	private TagRepository tagRepository;
	private PaperRepository paperRepo;

	    public TagController(UserRepository userRepository, TagRepository tagRepository,PaperRepository paperRepo) {
	        this.userRepository = userRepository;
	        this.tagRepository=tagRepository;
	        this.paperRepo=paperRepo;
	    }
	    @GetMapping
	    public String addtag(Model model, Principal principal) 
	    {  
	    	 String username = principal.getName(); // Get the username of the currently logged-in user
	         User user = userRepository.findByEmailId(username); // Retrieve the user details from the repository using the username
	         model.addAttribute("user", user);
	         model.addAttribute("paperCount", paperRepo.count());
	          List <Tag> list1 = tagRepository.findByUser(user);
    		 List<String> list = new ArrayList<String>(); 
    		 for(int i=0;i<list1.size();i++)
    		 {
    			  list.add(list1.get(i).getTag());
    		 }
    		 model.addAttribute("list",list);
    		 model.addAttribute("list1",list1);
	        return "tags";
	    }
	@PostMapping
	public String TagControllering( @RequestParam(name = "rmtag", required = false) String rmtag,@RequestParam("newtag")String tag,
			Principal principal,@ModelAttribute User user)
	{
		System.out.println("1"+tag);
		User user1=userRepository.findByEmailId(principal.getName());
		List <Tag> list1 = tagRepository.findByUser(user1);
		Tag tag1=tagRepository.findByUserAndTag(user1,tag);
		System.out.println(tag);
		if(tag!="")
		{
		if(tag1==null)
		{
			tag1=new Tag();
			 tag1.setTag(tag);
			 if(tag1!=null)
			 {
			 tag1.setUser(user1);
			 }
			 System.out.println(tag1.toString());
			tagRepository.save(tag1);
		}
         
		else
		{
			System.out.println("tag exsist");
		}
		
		}
		
		
		if(list1.size()>5)
		{
		if(rmtag!="")
		{
		Tag rmtag1=tagRepository.findByUserAndTag(user1,rmtag);
		if(rmtag1!=null)
		{
			tagRepository.delete(rmtag1);
		}
		else
		{
			System.out.println("tag doesn't exsist");
		}
		
		}
		}
		return "redirect:/tags?success";
    }
	

	
}
