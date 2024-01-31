package reviewer.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="paper")
public class Paper {
	
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long pid;
       private List<String> authors;
       
       @CreationTimestamp
       private LocalDateTime dateallocated;
       public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public LocalDateTime getDateallocated() {
		return dateallocated;
	}
	public void setDateallocated(LocalDateTime dateallocated) {
		this.dateallocated = dateallocated;
	}
	public LocalDateTime getDeadlinedate() {
		return deadlinedate;
	}
	public void setDeadlinedate(LocalDateTime deadlinedate) {
		this.deadlinedate = deadlinedate;
	}
	@CreationTimestamp
       private LocalDateTime deadlinedate;
       
	   
}
