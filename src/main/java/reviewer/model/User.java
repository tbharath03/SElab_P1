package reviewer.model;
import lombok.Builder;
import lombok.Data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Builder
@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
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
	 
    
    @JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)   
	private List<Review> review = new ArrayList<>();
 
	public User()
	{
		
	}
    

	public User(String emailId,String password)
	{
		this.emailId = emailId;
		this.password = password;
	}
	
	
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
	
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	 
	public Long getPaperlimit() {
		return paperlimit;
	}
	
	public void setPaperlimit(Long paperlimit) 
	{
		this.paperlimit = paperlimit;
	}
	
	@Override
	public String getPassword() {
		return password;
	} 
	  
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
