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
@RequestMapping("/")
public class ReviewController {
   
	@Autowired
	private UserService service;
	 /**
     * Displays the review page.
     *
     * @param model The model to add attributes to.
     * @return The logical view name "review".
     *
     * @see Review For information about the Review model.
     */

	@GetMapping("/review")
	public String reviewpage(Model model) 
	{
		Review review=new Review();
		System.out.println(review);
		model.addAttribute("review",review);
		System.out.println(review);
		return "review";
	}
	 /**
     * Handles the submission of a review.
     *
     * @param review The Review object containing review details.
     * @return Redirects to the dashboard page.
     *
     * @see Review For information about the Review model.
     * @see UserService For information about the UserService used for review processing.
     */
	@PostMapping("/review")
	public String review(@ModelAttribute Review review)
	{
		service.ReviewbyUser(review);
		return "dashboard";
	}
}
