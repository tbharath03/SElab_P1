package reviewer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import reviewer.util.Rkey;

@Entity
@Data
@Table(name="review")
public class Review 
{
	
	  @EmbeddedId
	   private Rkey rid;
       private Long technicalContentandAccuracy;	
       private Long significanceoftheWork;	
       private Long appropriateTitleLongroductionandConclusion;	
       private Long overallOrganization;
       private Long appropriateforSAC;	
       private Long styleandClarityofPaper;	
       private Long originalityofContent;	
       private Long refereesConfidenceinPapersSubject;	
       private Long overallRecommendation;
       private String comments;
       private String confidentialComments;
       private String decision;
       private String status="Need to Review";
    
    @JsonIgnore
   	@ManyToOne 
   	@MapsId("emailId")
   	@JoinColumn(name="email_id")
   	User user;
   	
   	@JsonIgnore
   	@ManyToOne 
  	@MapsId("pid")
   	@JoinColumn(name="p_id")
   	Paper paper;
      
	public Long getTechnicalContentandAccuracy() {
		return technicalContentandAccuracy;
	}
	 
	public void setTechnicalContentandAccuracy(Long technicalContentandAccuracy) {
		this.technicalContentandAccuracy = technicalContentandAccuracy;
	}
	
	public Long getSignificanceoftheWork() {
		return significanceoftheWork;
	}
	 
	public void setSignificanceoftheWork(Long significanceoftheWork) {
		this.significanceoftheWork = significanceoftheWork;
	}
	
	public Long getAppropriateTitleLongroductionandConclusion() {
		return appropriateTitleLongroductionandConclusion;
	}
	

	public void setAppropriateTitleLongroductionandConclusion(Long appropriateTitleLongroductionandConclusion) {
		this.appropriateTitleLongroductionandConclusion = appropriateTitleLongroductionandConclusion;
	}
	
	
	public Long getOverallOrganization() {
		return overallOrganization;
	}
	
	
	public void setOverallOrganization(Long overallOrganization) {
		this.overallOrganization = overallOrganization;
	}
	
    

	public Long getAppropriateforSAC() {
		return appropriateforSAC;
	}
	
    

	public void setAppropriateforSAC(Long appropriateforSAC) {
		this.appropriateforSAC = appropriateforSAC;
	}
	
	public Long getStyleandClarityofPaper() {
		return styleandClarityofPaper;
	}
	
	public void setStyleandClarityofPaper(Long styleandClarityofPaper) {
		this.styleandClarityofPaper = styleandClarityofPaper;
	}
	
	public Long getOriginalityofContent() {
		return originalityofContent;
	}
	
	public void setOriginalityofContent(Long originalityofContent) {
		this.originalityofContent = originalityofContent;
	}
	

	public Long getRefereesConfidenceinPapersSubject() {
		return refereesConfidenceinPapersSubject;
	}
    

	public void setRefereesConfidenceinPapersSubject(Long refereesConfidenceinPapersSubject) {
		this.refereesConfidenceinPapersSubject = refereesConfidenceinPapersSubject;
	}
	
	
	
	public Long getOverallRecommendation() {
		return overallRecommendation;
	}
	

	public Rkey getRid() {
		return rid;
	}

	public void setRid(Rkey rid) {
		this.rid = rid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public void setOverallRecommendation(Long overallRecommendation) {
		this.overallRecommendation = overallRecommendation;
	}
	

    

	public String getComments() {
		return comments;
	}
	
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	 
	
	public String getConfidentialComments() {
		return confidentialComments;
	}
	
	public void setConfidentialComments(String confidentialComments) {
		this.confidentialComments = confidentialComments;
	}

	 
	public Review(Rkey rid, Long technicalContentandAccuracy, Long significanceoftheWork,
			Long appropriateTitleLongroductionandConclusion, Long overallOrganization, Long appropriateforSAC,
			Long styleandClarityofPaper, Long originalityofContent, Long refereesConfidenceinPapersSubject,
			Long overallRecommendation, String comments, String confidentialComments, String decision,String status) {
		super();
		this.rid = rid;
		this.technicalContentandAccuracy = technicalContentandAccuracy;
		this.significanceoftheWork = significanceoftheWork;
		this.appropriateTitleLongroductionandConclusion = appropriateTitleLongroductionandConclusion;
		this.overallOrganization = overallOrganization;
		this.appropriateforSAC = appropriateforSAC;
		this.styleandClarityofPaper = styleandClarityofPaper;
		this.originalityofContent = originalityofContent;
		this.refereesConfidenceinPapersSubject = refereesConfidenceinPapersSubject;
		this.overallRecommendation = overallRecommendation;
		this.comments = comments;
		this.confidentialComments = confidentialComments;
		this.decision = decision;
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "Review [rid=" + rid + ", TechnicalContentandAccuracy=" + technicalContentandAccuracy
				+ ", SignificanceoftheWork=" + significanceoftheWork + ", AppropriateTitleLongroductionandConclusion="
				+ appropriateTitleLongroductionandConclusion + ", OverallOrganization=" + overallOrganization
				+ ", AppropriateforSAC=" + appropriateforSAC + ", StyleandClarityofPaper=" + styleandClarityofPaper
				+ ", OriginalityofContent=" + originalityofContent + ", RefereesConfidenceinPapersSubject="
				+ refereesConfidenceinPapersSubject + ", OverallRecommendation=" + overallRecommendation + ", comments="
				+ comments + ", ConfidentialComments=" + confidentialComments + ", decision=" + decision + "]";
	}
	
	 
	public Review() {
		super();
	}
	

	public String getDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	   
}