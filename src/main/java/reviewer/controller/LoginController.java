package reviewer.controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import reviewer.model.User;
import reviewer.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "login";
	}
	
	@PostMapping
	public String login1(@ModelAttribute User user) {
		//System.out.println("hello");
		return "redirect:/home";
	}
}
