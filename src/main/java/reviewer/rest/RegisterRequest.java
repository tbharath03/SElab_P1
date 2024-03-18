package reviewer.rest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor

public class RegisterRequest 
{
	private String emailId;
	private String firstName;
	private String lastName;
	private String number;
	private String password;
	private Long paperlimit;
    private String tag;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public RegisterRequest(String emailId, String firstName, String lastName, String number, String password,
			Long paperlimit, String tag) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.password = password;
		this.paperlimit = paperlimit;
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "RegisterRequest [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", number=" + number + ", password=" + password + ", paperlimit=" + paperlimit + ", tag=" + tag + "]";
	}
	public RegisterRequest() {
		super();
	}
	
	

}
