package reviewer.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

/**
 * Controller class for handling requests related to already reviewed content.
 */
@Controller
@RequestMapping("/AlreadyReviewed")
public class AlreadyReviewController {
	private UserRepository repo;
	private PaperRepository paperRepo;
	private ReviewRepository reviewRepo;
	public AlreadyReviewController(UserRepository repo,PaperRepository paperRepo,ReviewRepository reviewRepo) {
        this.repo = repo;
        this.paperRepo = paperRepo;
        this.reviewRepo = reviewRepo;
    }
	/**
     * Handles HTTP GET requests for the already reviewed page.
     *
     * @return The view name "AlreadyReviewed".
     */
	@GetMapping
    public String AlreadyReviewed(Model model, Principal principal){
		String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username); // Retrieve the user details from the repository using the username
        model.addAttribute("user", user); // Add the user details to the model
        model.addAttribute("paperCount", paperRepo.count());
        
		ArrayList<Review> reviews = reviewRepo.findAllByuserAndStatus(user,"Already Reviewed");
        ArrayList<Paper> papers = new ArrayList<Paper>();
        ArrayList<Paper> pp = new ArrayList<Paper>();
        reviews.forEach((rev)->{papers.add(rev.getPaper());});
        papers.forEach((p)->{
        	pp.add(paperRepo.findBypid(p.getPid()));
        	System.out.println(p.getPid());
        });
        
        System.out.println(pp);
        
        model.addAttribute("papers",pp);
        
        return "AlreadyReviewed";
    }
}