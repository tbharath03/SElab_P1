package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling dashboard-related requests.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	/**
     * Handles HTTP GET requests for the dashboard.
     *
     * @return The view name "dashboard".
     */
	@GetMapping
    public String dash(){
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