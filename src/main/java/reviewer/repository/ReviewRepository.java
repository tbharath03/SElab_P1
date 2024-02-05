package reviewer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.Review;
/**
 * Repository interface for managing Review entities.
 * This interface extends CrudRepository, providing basic CRUD operations.
 * The repository is responsible for interacting with the underlying data store.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review,Long>
{
	  /**
     * Retrieves a review by its unique ID.
     *
     * @param rid The review ID.
     * @return The Review object if found, otherwise null.
     */
	 Review findByrid(long rid);
}
