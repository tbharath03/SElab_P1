package reviewer.util;

public class EditProfileUtil {
	private String emailId;
	private String firstName;
	private String lastName;
	private String newPassword;
	private String number;
	private String oldPassword;
	private Long paperlimit;
	private String reEnterPassword;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Long getPaperlimit() {
		return paperlimit;
	}
	public void setPaperlimit(Long paperlimit) {
		this.paperlimit = paperlimit;
	}
	public String getReEnterPassword() {
		return reEnterPassword;
	}
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}
	@Override
	public String toString() {
		return "EditProfileUtil [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", newPassword=" + newPassword + ", number=" + number + ", oldPassword=" + oldPassword
				+ ", papeerlimit=" + paperlimit + ", reEnterPassword=" + reEnterPassword + "]";
	}
	
	
}
