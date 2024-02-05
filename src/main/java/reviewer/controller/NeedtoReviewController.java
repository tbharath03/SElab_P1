package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling requests related to content that needs to be reviewed.
 */
@Controller
@RequestMapping("/NeedtoReview")
public class NeedtoReviewController {
	/**
     * Handles HTTP GET requests for the content that needs to be reviewed.
     *
     * @return The view name "NeedtoReview".
     */
	@GetMapping
    public String NeedtoReview(){
        return "NeedtoReview";
    }	
}