package reviewer.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reviewer.model.User;
import reviewer.repository.UserRepository;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home/login")
public class ApiLoginController {
	private UserRepository repo;

	@GetMapping
	  public User loginUser(@RequestBody LoginRequest user)
	{
		
		User user1 = new User();
		user1=repo.findByEmailId(user.getEmailId());
		
     return user1;
	}
	
}
