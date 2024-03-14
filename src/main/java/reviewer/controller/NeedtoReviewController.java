package reviewer.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.model.User;
import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

/**
 * Controller class for handling requests related to content that needs to be reviewed.
 */
@Controller
@RequestMapping("/NeedtoReview")
public class NeedtoReviewController {
	private UserRepository repo;
	private PaperRepository paperRepo;
	@Autowired
	ReviewRepository reviewRepo;
	public NeedtoReviewController(UserRepository repo,PaperRepository paperRepo,ReviewRepository reviewRepo) {
        this.repo = repo;
        this.paperRepo = paperRepo;
        this.reviewRepo=reviewRepo;
    }
	
	@GetMapping
    public String NeedtoReview(Model model, Principal principal){
		
		
		String username = principal.getName(); // Get the username of the currently logged-in user
        User user = repo.findByEmailId(username); // Retrieve the user details from the repository using the username
        model.addAttribute("user", user); // Add the user details to the model
        model.addAttribute("paperCount", paperRepo.count());
        ArrayList<Review> reviews = reviewRepo.findAllByuserAndStatus(user,"Need to Review");
        ArrayList<Paper> papers = new ArrayList<Paper>();
        ArrayList<Paper> pp = new ArrayList<Paper>();
        reviews.forEach((rev)->{papers.add(rev.getPaper());});
        papers.forEach((p)->{
        	pp.add(paperRepo.findBypid(p.getPid()));
        	System.out.println(p.getPid());
        });
        
        System.out.println(pp);
        
        model.addAttribute("papers",pp);
		
        return "NeedtoReview";
    }	
}