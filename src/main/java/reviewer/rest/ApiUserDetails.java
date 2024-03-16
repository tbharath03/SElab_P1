package reviewer.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reviewer.model.User;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ApiUserDetails {
	
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	
	public ApiUserDetails(UserRepository userRepository,ReviewRepository reviewRepository) {
		this.userRepository = userRepository;
		this.reviewRepository = reviewRepository;
	}
	
	@GetMapping("/user")
	public User getUserDetails(Principal principal) {
		String username = principal.getName();
		User user = userRepository.findByEmailId(username);
		return user;
	}
	
	@GetMapping("/paperCount")
    public Long getPaperCount(Principal principal) {
    	User user = getUserDetails(principal);
    	return reviewRepository.countByUserAndStatus(user,"Already Reviewed");
    }
}
