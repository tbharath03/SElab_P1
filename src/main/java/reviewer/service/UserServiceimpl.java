package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;
/**
 * Service implementation for user-related operations.
 */
@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	private UserRepository repo;
	private ReviewRepository reviewRepository;
	/**
     * Constructor to inject dependencies.
     *
     * @param reviewRepository The repository for reviews.
     */
    public UserServiceimpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Registers a new user.
     *
     * @param user The user to register.
     */

	@Override
	public void registerUser(User user) {
	
		repo.save(user);
	}
	/**
     * Submits a review by the user.
     *
     * @param review The review to be submitted.
     */
	@Override
	public void ReviewbyUser(Review review) 
	{
		reviewRepository.save(review);
	}

}
