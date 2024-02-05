package reviewer.model;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


/**
 * This is a user class;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//check for identity type in java guides there is generated value
	//for id sequence generator see video
	//for no null constraint @Column(name ="string name",nullable=false)
	@Id
	private String emailId;
//	private Long userid;
	private String firstName;
	private String lastName;
	private String number;
	private String password;
	private Long paperlimit;
	// no argument constructor is used in controller
	public User()
	{
		
	}
	
	public User(String emailId,String password)
	{
		this.emailId = emailId;
		this.password = password;
	}
	// all argument constructor
	public User(Long userid2, String firstName2, String lastName2, String emailId2, String number2, String encode,
			Long paperlimit2, List<String> tags2) {
//		  this.userid=userid2;
		  this.firstName=firstName2;
		  this.lastName=lastName2;
		  this.emailId=emailId2;
		  this.number=number2;
		  this.password=encode;
		  this.paperlimit=paperlimit2;
//		  this.tags=tags2;  
	}
//	public Long getUserid() {
//		return userid;
//	}
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPaperlimit() {
		return paperlimit;
	}
	public void setPaperlimit(Long paperlimit) {
		this.paperlimit = paperlimit;
	}
//	public List<String> getTags() {
//		return tags;
//	}
//	public void setTags(List<String> tags) {
//		this.tags = tags;
//	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Email=" +emailId  + ", password=" + password + ", Firstname=" + firstName + ",LastName=" + lastName +" contactno=" + number
				 ;
	}

//	private List<String> tags;
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
}