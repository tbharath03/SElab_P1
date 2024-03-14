package reviewer.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entity class representing a Paper in the application.
 */
@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name="paper")
public class Paper {
	
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long pid;
       private String title;
       private String authors;
       
       @CreationTimestamp
       private LocalDateTime dateallocated;
       private String paperlink;
       
       @OneToMany(mappedBy="paper")
       List<Review> reviews;
       public Long getPid() {
		return pid;
	}
       
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
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
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getPaperlink() {
		return paperlink;
	}

	public void setPaperlink(String paperlink) {
		this.paperlink = paperlink;
	}
	@CreationTimestamp
     private LocalDateTime deadlinedate;
       
	   
}