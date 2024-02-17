package reviewer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import reviewer.model.Tag;
import reviewer.model.User;


public interface TagRepository extends JpaRepository<Tag,Long> 
{
	Tag findByTag(String tag);
	List <Tag> findByUser(User user);
	Tag findByUserAndTag(User user, String tag);
}
