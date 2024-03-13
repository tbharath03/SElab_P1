package reviewer.util;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class Rkey implements Serializable {
	
	@Column(name="email_id")
	private String emailId;
	@Column(name="p_id")
	private Long pid;
	

	 public Rkey(){
			
		}

		public Rkey(Long pid, String emailId) {
			
			this.pid = pid;
			this.emailId = emailId;
			
		}
}