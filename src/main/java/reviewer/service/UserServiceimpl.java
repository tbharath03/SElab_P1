package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reviewer.model.User;
import reviewer.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	private UserRepository repo;
	
	@Override
	public void registerUser(User user) {
	
		repo.save(user);
	}

	
	
	
	

}
