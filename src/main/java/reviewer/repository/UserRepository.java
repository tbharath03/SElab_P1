package reviewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import reviewer.model.User;
/**
 * Repository interface for performing CRUD operations on User entities.
 */
@Repository
public interface UserRepository extends CrudRepository<User,String>{
	/**
     * Retrieves a user based on their email ID.
     *
     * @param emailId The email ID of the user to be retrieved.
     * @return The User object associated with the provided email ID.
     */
//   user findByEmail(String emailId);
	 User findByEmailId(String emailId);
	 /**
	     * Retrieves an Optional containing a user based on their ID.
	     *
	     * @param emailId The ID of the user to be retrieved.
	     * @return An Optional containing the User object associated with the provided ID.
	     */
	 Optional<User> findById(String emailId);

}