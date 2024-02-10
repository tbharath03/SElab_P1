package reviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/**
 * Configuration class for Spring Security.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private UserDetailsService userDetailsService;
	/**
     * Configures the password encoder bean to use BCrypt hashing algorithm.
     *
     * @return BCryptPasswordEncoder bean.
     */
	@Bean
	PasswordEncoder passwordEncoder()     
	{   
		return new BCryptPasswordEncoder();
	}
	/**
     * Configures the authentication provider bean using DaoAuthenticationProvider.
     *
     * @return DaoAuthenticationProvider bean.
     */
	@Bean
	AuthenticationProvider authenticationprovider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
	}
	/**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http HttpSecurity object to configure security settings.
     * @return SecurityFilterChain object.
     * @throws Exception if an error occurs during configuration.
     */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {     //need to understand 
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home","/login","/registerPage","/forgotpassword","/resetpassword").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/dashboard", true)
				
			)
			.logout((logout) -> logout.permitAll());
		// Builds and returns the configured SecurityFilterChain
		return http.build();
	}
	

	
}