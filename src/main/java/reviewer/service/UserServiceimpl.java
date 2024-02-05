package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	private UserRepository repo;
	private ReviewRepository reviewRepository;
    public UserServiceimpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

	
	@Override
	public void registerUser(User user) {
	
		repo.save(user);
	}

	@Override
	public void ReviewbyUser(Review review) 
	{
		reviewRepository.save(review);
	}

}
