package reviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.Review;
import reviewer.service.UserService;

@Controller
@RequestMapping("/")
public class ReviewController {

	@Autowired
	private UserService service;
	
	@GetMapping("/review")
	public String reviewpage(Model model) 
	{
		Review review=new Review();
		System.out.println(review);
		model.addAttribute("review",review);
		System.out.println(review);
		return "review";
	}
	
	@PostMapping("/review")
	public String review(@ModelAttribute Review review)
	{
		service.ReviewbyUser(review);
		return "dashboard";
	}
}