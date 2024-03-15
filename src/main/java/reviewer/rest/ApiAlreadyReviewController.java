package reviewer.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.PaperRepository;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

@RestController
@RequestMapping("/api/AlreadyReviewed")
public class ApiAlreadyReviewController {
	 	private final UserRepository userRepository;
	    private final PaperRepository paperRepository;
	    private final ReviewRepository reviewRepository;

	    public ApiAlreadyReviewController(UserRepository userRepository, PaperRepository paperRepository,
	            ReviewRepository reviewRepository) {
	        this.userRepository = userRepository;
	        this.paperRepository = paperRepository;
	        this.reviewRepository = reviewRepository;
	    }
	    
	    @GetMapping
	    public List<Paper> getAlreadyReviewedPapers(Principal principal) {
	    	User user = getUser(principal);
	        List<Review> reviews = reviewRepository.findAllByuserAndStatus(user, "Already Reviewed");
	        List<Paper> alreadyReviewedPapers = new ArrayList<>();

	        for (Review review : reviews) {
	            Paper paper = review.getPaper();
	            alreadyReviewedPapers.add(paper);
	        }
	        return alreadyReviewedPapers;
	    }
	    
	    @GetMapping
	    public User getUser(Principal principal) {
	    	String username = principal.getName(); // Get the username of the currently logged-in user
	        User user = userRepository.findByEmailId(username); // Retrieve the user details from the repository using the username
	        
	        return user;
	    }
	    
	    @GetMapping
	    public Long getPaperCount(Principal principal) {
	    	User user = getUser(principal);
	    	return reviewRepository.countByUserAndStatus(user,"Already Reviewed");
	    }
}
