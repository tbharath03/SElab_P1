package reviewer.model;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
//import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
/**
 * Represents a user entity with authentication details.
 *
 * This class defines the structure of a user entity, including authentication details
 * such as email, password, and roles. It also implements the UserDetails interface
 * for integration with Spring Security.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table(name="User",
schema ="nitconf",
uniqueConstraints= {
		@UniqueConstraint(
		name="emailId_unique",
		 columnNames = { "emailId" }
)
})



public class User implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	private String emailId;
	private String firstName;
	private String lastName;
	private String number;
	private String password;
	private Long paperlimit;
    private String tag;
	  /**
     * No-argument constructor used in the controller.
     */
 
	public User()
	{
		
	}
    /**
     * Constructor with emailId and password used for authentication.
     *
     * @param emailId  The email ID.
     * @param password The password.
     */

	public User(String emailId,String password)
	{
		this.emailId = emailId;
		this.password = password;
	}
	
	   /**
     * All-argument constructor for creating a User object.
     *
     * @param userId     The user ID.
     * @param firstName  The first name.
     * @param lastName   The last name.
     * @param emailId    The email ID.
     * @param number     The contact number.
     * @param encode     The encoded password.
     * @param paperlimit The paper limit.
     */
	
	/**
     * Returns the user's first name.
     *
     * @return The first name.
     */
	public String getFirstName() {
		return firstName;
	}
	public User(String emailId, String firstName, String lastName, String number, String password, Long paperlimit,
			String tag) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.password = password;
		this.paperlimit = paperlimit;
		this.tag = tag;
	}
	/**
     * Sets the user's first name.
     *
     * @param firstName The first name to set.
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	 /**
     * Returns the user's last name.
     *
     * @return The last name.
     */
	public String getLastName() {
		return lastName;
	}

    /**
     * Sets the user's last name.
     *
     * @param lastName The last name to set.
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 /**
     * Returns the user's contact number.
     *
     * @return The contact number.
     */
	public String getEmailId() {
		return emailId;
	}
	  /**
     * Sets the user's contact number.
     *
     * @param number The contact number to set.
     */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
     * Returns the user's encoded password.
     *
     * @return The encoded password.
     */
	public String getNumber() {
		return number;
	}
	/**
     * Returns the user's encoded password.
     *
     * @return The encoded password.
     */
	public void setNumber(String number) {
		this.number = number;
	}
	
	 /**
     * Sets the user's encoded password.
     *
     * @param password The encoded password to set.
     */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	 /**
     * Sets the user's encoded password.
     *
     * @param password The encoded password to set.
     */
	public Long getPaperlimit() {
		return paperlimit;
	}
	 /**
     * Sets the user's paper limit.
     *
     * @param paperlimit The paper limit to set.
     */
	public void setPaperlimit(Long paperlimit) 
	{
		this.paperlimit = paperlimit;
	}
	
	@Override
	public String getPassword() {
		return password;
	} 
	  /**
     * Returns a string representation of the User.
     *
     * @return A string representation.
     */


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	@Override
	public String getUsername() {
		return emailId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}	
}
