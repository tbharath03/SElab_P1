package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import reviewer.repository.UserRepository;
import reviewer.model.User;

/**
 * Service class implementing the UserDetailsService interface for custom user authentication.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository; 
	/**
     * Retrieves a UserDetails object based on the provided username.
     *
     * @param username The username for which UserDetails is to be loaded.
     * @return UserDetails object for the specified username.
     * @throws UsernameNotFoundException If the user with the given username is not found.
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userRepository.findByEmailId(username);
		
		if(user!= null)
		{
			System.out.print("im here in security for login");
			if(user.getConfirm()==1L)
			{
			return (UserDetails) user;
			}
		}
		
		
		System.out.println("Usernotfound");
		throw new UsernameNotFoundException("Username Not Found");
	} 
	
	
}