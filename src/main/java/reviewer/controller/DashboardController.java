package reviewer.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.UserRepository;

/**
 * Controller class for handling dashboard-related requests.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	private UserRepository repo;
	private PaperRepository paperRepo;
	public DashboardController(UserRepository repo,PaperRepository paperRepo) {
        this.repo = repo;
        this.paperRepo = paperRepo;
    }
	/**
     * Handles HTTP GET requests for the dashboard.
     *
     * @return The view name "dashboard".
     */
	@GetMapping
    public String dash(Model model, Principal principal){
		String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username); // Retrieve the user details from the repository using the username
        model.addAttribute("user", user); // Add the user details to the model
        model.addAttribute("paperCount", paperRepo.count());
        return "dashboard";
    }
	/**
     * Handles HTTP POST requests for the dashboard.
     *
     * @return The view name "home".
     */
    @PostMapping
    public String Dash()
    {
    	return "home";
    }
}