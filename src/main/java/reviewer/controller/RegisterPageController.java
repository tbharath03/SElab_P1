package reviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.User;
import reviewer.service.UserService;

@Controller
@RequestMapping("/")
public class RegisterPageController {

	@Autowired
	private UserService service;
	
	@GetMapping("/registerPage")
	public String registerpage(Model model) 
	{
		User user=new User(null, null, null, null, null, null, null, null);
				model.addAttribute("user",user);
		return "registerPage";
	}
	
	@PostMapping("/register")
	public String UserRegistration(@ModelAttribute User user)
	{
		System.out.println(user);
		service.registerUser(user);
		return "home";
	}
}