package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling user logout-related requests.
 */
@Controller
@RequestMapping("/logout")

public class LogoutController {
	/**
	 * Handles HTTP GET requests for user logout.
	 *
	 * @return The view name "home" after the user logs out.
	 */
	@GetMapping
	public String logout() {
		return "home";
	}
}