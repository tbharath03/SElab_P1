package reviewer.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;
import reviewer.service.UserService;
import reviewer.util.Rkey;
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
	private UserRepository repo;
	private PaperRepository paperRepo;
	private ReviewRepository reviewRepo;
	public ReviewController(UserRepository repo,PaperRepository paperRepo,ReviewRepository reviewRepo) {
        this.repo = repo;
        this.paperRepo = paperRepo;
        this.reviewRepo = reviewRepo;
    }
	 /**
     * Displays the review page.
     *
     * @param model The model to add attributes to.
     * @return The logical view name "review".
     *
     * @see Review For information about the Review model.
     */

	@GetMapping("/review/{id}")
	public String reviewpage(Model model,Principal principal,@PathVariable("id") Long paperId) 
	{
//		Review review=new Review();
//		System.out.println(review);
//		model.addAttribute("review",review);
//		System.out.println(review);
		String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username);
        model.addAttribute("user",user);
        
        model.addAttribute("paper",paperRepo.findBypid(paperId));
		
			Review review = reviewRepo.findById(new Rkey(paperId,username)).get();
		    model.addAttribute("review",review);
		
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
	public String review(@ModelAttribute Review review,Principal principal,
			@RequestParam("id") Long paperId)
	{
		
		String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username);
        review.setRid(new Rkey(paperId,username));
        
//		review.setUser(user);
		Paper paper = paperRepo.findBypid(paperId);
		review.setStatus("Already reviewed");
//		review.setPaper(paper);
		System.out.println(review);
		reviewRepo.save(review);
		
		return "redirect:/dashboard";
	}
}
