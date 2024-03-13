package reviewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import reviewer.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
//   user findByEmail(String emailId);
	 User findByEmailId(String emailId);
	 
	 Optional<User> findById(String emailId);

}