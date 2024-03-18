package reviewer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.repository.ReviewRepository;
import reviewer.repository.UserRepository;
import reviewer.rest.ApiAlreadyReviewController;
import reviewer.util.Rkey;

@ExtendWith(MockitoExtension.class)
public class ApiAlreadyReviewedControllerTest {

    @Mock
    private ReviewRepository reviewRepository;
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ApiAlreadyReviewController apiAlreadyReviewController;

    private User user;
    

    private Paper paper1;
    private Paper paper2;
    private Paper paper3;

    private Review review1;
    private Review review2;
    private Review review3;
    
    @BeforeEach
    public void setup() {
    	user = new User("sumantht2004@gmail.com","Sumanth","Yadav","6304561816","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",7L,",HELLO,BYE,OK,NICE,GOOD");
    	LocalDateTime now = LocalDateTime.now();
    	paper1 = new Paper(1L, "title1", "author1a, author1b", now, "link1", now);
    	paper2 = new Paper(2L, "title2", "author2a, author2b", now, "link2", now);
    	paper3 = new Paper(3L, "title3", "author3a, author3b", now, "link3", now);
    	
    	Rkey rid1 = new Rkey(1L, user.getEmailId());
    	Rkey rid2 = new Rkey(2L, user.getEmailId());
    	Rkey rid3 = new Rkey(3L, user.getEmailId());

    	review1 = new Review(rid1, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L, "good comment", "good confidential comment",
                "accept as it is","Already Reviewed");
      	review2 = new Review(rid2, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, "decent comment", "decent confidential comment",
                "accept with minor revisions","Already Reviewed");
      	review3 = new Review(rid3, 5L, 9L, 8L, 4L, 6L, 8L, 7L, 9L, 6L, "bad comment", "bad confidential comment", "reject","Already Reviewed");
      }
    
    
    @Test
    public void findAllByuserAndStatusForNonEmpty() throws Exception{	
    	
    	ArrayList<Review> reviews = new ArrayList<>();
    	reviews.add(review1);
    	reviews.add(review2);
    	reviews.add(review3);
    	when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);
    	
    	when(reviewRepository.findAllByuserAndStatus(user, "Already Reviewed")).thenReturn(reviews);
    	
    	List<Paper> result = apiAlreadyReviewController.getAlreadyReviewedPapers(user.getEmailId());
    	
    	assertEquals(3, result.size());
    }
    
    @Test
    public void findAllByuserAndStatusForEmpty() throws Exception{
    	
    	ArrayList<Review> reviews = new ArrayList<Review>();
    	
    	when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);
    	
    	when(reviewRepository.findAllByuserAndStatus(user, "Already Reviewed")).thenReturn(reviews);
    	
    	List<Paper> result = apiAlreadyReviewController.getAlreadyReviewedPapers(user.getEmailId());
    	
    	assertEquals(0, result.size());
    }
    
    @Test
    public void noReviewsFoundOnUsername() throws Exception{
    	
    	ArrayList<Review> reviews = new ArrayList<Review>();
    	reviews.add(review1);
    	reviews.add(review2);
    	User user = new User();
    	user.setEmailId("test@google.com");
    	when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);
    	
    	
    	List<Paper> result = apiAlreadyReviewController.getAlreadyReviewedPapers(user.getEmailId());
    	
    	assertEquals(0, result.size());
    }

}






