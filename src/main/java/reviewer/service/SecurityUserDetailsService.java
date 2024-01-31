package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import reviewer.repository.UserRepository;
import reviewer.model.User;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userRepository.findByEmailId(username);
		
		if(user!= null)
			return (UserDetails) user;
		
		System.out.println("Usernotfound");
		throw new UsernameNotFoundException("Username Not Found");
	} 
	
	
}