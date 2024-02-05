package reviewer.service;

import reviewer.model.Review;
import reviewer.model.User;

public interface UserService {
   public void registerUser(User user);
   
   public void ReviewbyUser(Review review);
  
}
