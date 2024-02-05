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
/**
 * Entity class representing a Paper in the application.
 */
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
       
       /**
        * Gets the unique identifier of the paper.
        *
        * @return The paper's ID.
        */
       public Long getPid() {
		return pid;
	}
       /**
        * Sets the unique identifier of the paper.
        *
        * @param pid The paper's ID to be set.
        */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
     * Gets the list of authors associated with the paper.
     *
     * @return The list of authors.
     */
	public List<String> getAuthors() {
		return authors;
	}
	/**
     * Sets the list of authors associated with the paper.
     *
     * @param authors The list of authors to be set.
     */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	 /**
     * Gets the date when the paper was allocated.
     *
     * @return The date of paper allocation.
     */
	public LocalDateTime getDateallocated() {
		return dateallocated;
	}
	/**
     * Sets the date when the paper was allocated.
     *
     * @param dateallocated The date of paper allocation to be set.
     */
	public void setDateallocated(LocalDateTime dateallocated) {
		this.dateallocated = dateallocated;
	}
	/**
     * Gets the deadline date associated with the paper.
     *
     * @return The deadline date for the paper.
     */
	public LocalDateTime getDeadlinedate() {
		return deadlinedate;
	}
	/**
     * Sets the deadline date associated with the paper.
     *
     * @param deadlinedate The deadline date for the paper to be set.
     */
	public void setDeadlinedate(LocalDateTime deadlinedate) {
		this.deadlinedate = deadlinedate;
	}
	@CreationTimestamp
       private LocalDateTime deadlinedate;
       
	   
}
