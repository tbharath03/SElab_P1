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
    private Tag tag6;
    private Tag tag7;
    private Tag tag8;

	private OngoingStubbing<User> thenReturn;
 
    
    @BeforeEach
    public void setup() {
    	user1 = new User("aish1@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",ML,FOP,CG,IIS,JAVA");
    	user2 = new User("aish2@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",HELLO,BYE,OK,NICE,GOOD");
    	user3 = new User("aish3@gmail.com","aishwarya","attanti","8790373183","$2a$10$ZDi8mRBt3T1g8vbu9.5KT.4cK3a4QhnnFVWWPyCrClAVFaTfwnfhy",1L,",HELLO,BYE,OK,NICE,GOOD");
    	
    	tag1=new Tag();
    	tag1.setTag("ML");
    	tag1.setUser(user1);
    	tag1.setId(1L);
    
    	
    	tag2=new Tag();
    	tag2.setTag("FOP");
    	tag2.setUser(user1);
    	tag2.setId(2L);
    	
    	tag3=new Tag();
    	tag3.setTag("CG");
    	tag3.setUser(user1);
    	tag3.setId(3L);
    	
    	tag4=new Tag();
    	tag4.setTag("IIS");
    	tag4.setUser(user1);
    	tag4.setId(4L);
    	
        tag5=new Tag();
    	tag5.setTag("JAVA");
    	tag5.setUser(user1);
    	tag5.setId(5L);
    	
    	 tag6=new Tag();
     	tag6.setTag("JAVA1");
     	tag6.setUser(user1);
     	tag1.setId(6L);
     	
     	 tag7=new Tag();
     	tag7.setTag("JAVA2");
     	tag7.setUser(user1);
     	tag7.setId(7L);
     	
     	 tag8=new Tag();
     	tag8.setTag("JAVA3");
     	tag8.setUser(user1);
     	tag8.setId(8L);
     	
     	

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
    public void addtags() throws Exception{	
    	Tag tag6=new Tag();
    	tag6.setTag("newtag");
    	tag6.setUser(user1);
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
   
  	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result = apitagController.addTags("newtag",user1.getEmailId());
	
	assertEquals(result.size(),6);

    }
   
   @Test
   public void addnulltag() throws Exception{	
   	Tag tag6=new Tag();
   	tag6.setTag("newtag");
   	tag6.setUser(user1);
   	ArrayList<Tag> tags = new ArrayList<>();
   	tags.add(tag1);
   	tags.add(tag2);
   	tags.add(tag3);
   	tags.add(tag4);
   	tags.add(tag5);
  
 	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result = apitagController.addTags("",user1.getEmailId());
	
	assertEquals(result.size(),5);

   }
   
   @Test
   public void bothnulltag() throws Exception{	
   	Tag tag6=new Tag();
   	tag6.setTag("newtag");
   	tag6.setUser(user1);
   	ArrayList<Tag> tags = new ArrayList<>();
   	tags.add(tag1);
   	tags.add(tag2);
   	tags.add(tag3);
   	tags.add(tag4);
   	tags.add(tag5);
  
 	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result = apitagController.addTags("",user1.getUsername());
	
	assertEquals(result.size(),5);

   }
    
    
    @Test
    public void addexistingtags() throws Exception{	
    	Tag tag6=new Tag();
    	tag6.setTag("newtag");
    	tag6.setUser(user1);
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
  	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result1 = apitagController.getTags(user1.getUsername());
	System.out.print(result1.size());
	List<String> result = apitagController.addTags(tag5.getTag(),user1.getEmailId());
	System.out.print(result.size());
	assertEquals(result.size(),5);

    }
    
    
    @Test
    public void deletetagscheck() throws Exception{	
    	
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
    	
    	ArrayList<String> dtags = new ArrayList<>();
    	dtags.add(tag1.getTag());
    	dtags.add(tag2.getTag());
    	dtags.add(tag3.getTag());
      
  	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result = apitagController.tagDeletes(dtags,user1.getUsername());
	
	assertEquals(result.size(),5);

    }
    
    @Test
    public void deletetags() throws Exception{	
    	
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
        tags.add(tag6);
        tags.add(tag7);
        tags.add(tag8);
    	
    	ArrayList<String> dtags = new ArrayList<>();
    	dtags.add(tag1.getTag());
    	dtags.add(tag2.getTag());
    	dtags.add(tag3.getTag());
    	dtags.add(tag4.getTag());
    	dtags.add(tag5.getTag());
    	
  	when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(user1);
	
	when(tagRepository.findByUser(user1)).thenReturn(tags);
	List<String> result = apitagController.tagDeletes(dtags,user1.getUsername());
	
	assertEquals(result.size(),5);

    }
    
    @Test
    public void notagtoUser() throws Exception{	
    	ArrayList<Tag> tags = new ArrayList<>();
    	tags.add(tag1);
    	tags.add(tag2);
    	tags.add(tag3);
    	tags.add(tag4);
    	tags.add(tag5);
    	
    	user2.setEmailId("test@google.com");
  	when(userRepository.findByEmailId(user2.getEmailId())).thenReturn(user2);
	List<String> result = apitagController.getTags(user2.getUsername());
	

    	
	assertEquals(result.size(),0);

    }
  

}






