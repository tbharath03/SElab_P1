package reviewer.rest;


import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reviewer.model.User;
import reviewer.repository.UserRepository;



@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/login")
public class ApiLoginController {
	private UserRepository repo;

	@GetMapping("/{id}")
	  public User loginUser(@RequestBody LoginRequest user,@PathVariable("id") String emailId)
	{
		
		User user1 = new User();
		user1=repo.findByEmailId(user.getEmailId());
		
     return user1;
	}
	
}
