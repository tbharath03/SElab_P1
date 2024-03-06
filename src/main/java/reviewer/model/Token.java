package reviewer.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name="Token")
public class Token 
{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String token;

    private LocalDateTime expirationTime;

 

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}









	public Token(Long id, User user, String token, LocalDateTime expirationTime) {
		super();
		this.id = id;
		this.user = user;
		this.token = token;
		this.expirationTime = expirationTime;
	}









	@Override
	public String toString() {
		return "Token [id=" + id + ", user=" + user + ", token=" + token + ", expirationTime=" + expirationTime + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirationTime = expirationTime;
	}









	 public boolean isExpired(LocalDateTime expiryDateTime) {
	        LocalDateTime currentTime = LocalDateTime.now();
	        return currentTime.isAfter(expiryDateTime);
	    }





    
}
