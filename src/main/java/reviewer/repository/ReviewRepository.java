package reviewer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.Review;
import reviewer.model.User;
import reviewer.util.Rkey;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Rkey>{
      
	 Review findByrid(Rkey rid);
	 ArrayList<Review> findAllByuser(User user);
	 ArrayList<Review> findAllByuserAndStatus(User user,String status);
	 Long countByUserAndStatus(User user,String status);
}
