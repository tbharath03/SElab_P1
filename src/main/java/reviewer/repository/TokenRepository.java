package reviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import reviewer.model.Token;
import reviewer.model.User;

public interface TokenRepository extends JpaRepository<Token,Long> 
{
	//Token findByUserAndToken(User user,String token);

	Token findByToken(String token);

	Token findByUserAndToken(User user, String token);
}
