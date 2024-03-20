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
import org.mockito.stubbing.OngoingStubbing;

import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.Tag;
import reviewer.model.User;
import reviewer.repository.ReviewRepository;
import reviewer.repository.TagRepository;
import reviewer.repository.UserRepository;
import reviewer.rest.ApiAlreadyReviewController;
import reviewer.rest.ApiTagController;
import reviewer.util.Rkey;

@ExtendWith(MockitoExtension.class)
public class ApiTagControllerTest {

    @Mock
    private TagRepository tagRepository;
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ApiTagController apitagController;

   

    private User user1;
    private User user2;
    private User user3;

    private Tag tag1;
    private Tag tag2;
    private Tag tag3;
    private Tag tag4;
    private Tag tag5;

	private OngoingStubbing<User> thenReturn;
 
    
    @BeforeEach
    public void setup() {
    	user1 = new User("aish1@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",ML,FOP,CG,IIS,JAVA");
    	user2 = new User("aish2@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",HELLO,BYE,OK,NICE,GOOD");
    	user3 = new User("aish3@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",HELLO,BYE,OK,NICE,GOOD");
    	
    	tag1=new Tag();
    	tag1.setTag("ML");
    	tag1.setUser(user1);
    	
    	tag2=new Tag();
    	tag2.setTag("FOP");
    	tag2.setUser(user1);
    	
    	tag3=new Tag();
    	tag3.setTag("CG");
    	tag3.setUser(user1);
    	
    	tag4=new Tag();
    	tag4.setTag("IIS");
    	tag4.setUser(user1);
    	
        tag5=new Tag();
    	tag5.setTag("JAVA");
    	tag5.setUser(user1);
    	
    	

      }
    
    
    @Test
    public void findAllTagbyUser() throws Exception{	
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
    	//List <Tag> list1 = tagRepository.findByUser(user1);
 
  	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	
	List<String> result = apitagController.getTags(user1.getUsername());
    	
	assertEquals(result.size(),5);
    
    }
    
    
    @Test
    public void findNoTagbyUser() throws Exception{	
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
    	//List <Tag> list1 = tagRepository.findByUser(user1);

    	user2.setEmailId("test@google.com");
  	when(userRepository.findByEmailId(user2.getEmailId())).thenReturn(user2);

	
	System.out.print(user2.getUsername());
	List<String> result = apitagController.getTags(user2.getUsername());
	
	System.out.print(result.size());
    	
	assertEquals(result.size(),0);

    }
  

}






