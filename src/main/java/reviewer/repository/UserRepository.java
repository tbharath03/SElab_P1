package reviewer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

//   user findByEmail(String emailId);
	 User findByEmailId(String emailId);
	 
}