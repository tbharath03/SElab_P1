package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling requests related to already reviewed content.
 */
@Controller
@RequestMapping("/AlreadyReviewed")
public class AlreadyReviewController {
	/**
     * Handles HTTP GET requests for the already reviewed page.
     *
     * @return The view name "AlreadyReviewed".
     */
	@GetMapping
    public String AlreadyReviewed(){
        return "AlreadyReviewed";
    }
}