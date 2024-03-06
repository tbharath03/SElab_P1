package reviewer.service;

import reviewer.model.Review;
import reviewer.model.Tag;
import reviewer.model.User;
/**
 * Service interface for user-related operations.
 */
public interface UserService {
    /**
     * Registers a new user.
     *
     * @param user The user to register.
     */

   public void registerUser(User user);
   /**
    * Submits a review by the user.
    *
    * @param review The review to be submitted.
    */

   public void ReviewbyUser(Review review);

public void addTag(Tag tag);
  
}
