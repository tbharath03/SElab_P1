package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling home-related requests.
 */
@Controller
public class HomeController {
	/**
     * Handles HTTP GET requests for the home page.
     *
     * @return The view name "home".
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }
}