package reviewer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long>
{

	 Review findByrid(long rid);
}