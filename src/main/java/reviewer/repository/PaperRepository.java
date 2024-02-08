package reviewer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.Paper;

@Repository
public interface PaperRepository extends CrudRepository<Paper,Long>{
	
}
