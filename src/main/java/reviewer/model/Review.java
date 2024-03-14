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
       private Long TechnicalContentandAccuracy;	
       private Long SignificanceoftheWork;	
       private Long AppropriateTitleLongroductionandConclusion;	
       private Long OverallOrganization;
       private Long AppropriateforSAC;	
       private Long StyleandClarityofPaper;	
       private Long OriginalityofContent;	
       private Long RefereesConfidenceinPapersSubject;	
       private Long OverallRecommendation;
       private String comments;
       private String ConfidentialComments;
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
		return TechnicalContentandAccuracy;
	}
	 
	public void setTechnicalContentandAccuracy(Long technicalContentandAccuracy) {
		TechnicalContentandAccuracy = technicalContentandAccuracy;
	}
	
	public Long getSignificanceoftheWork() {
		return SignificanceoftheWork;
	}
	 
	public void setSignificanceoftheWork(Long significanceoftheWork) {
		SignificanceoftheWork = significanceoftheWork;
	}
	
	public Long getAppropriateTitleLongroductionandConclusion() {
		return AppropriateTitleLongroductionandConclusion;
	}
	

	public void setAppropriateTitleLongroductionandConclusion(Long appropriateTitleLongroductionandConclusion) {
		AppropriateTitleLongroductionandConclusion = appropriateTitleLongroductionandConclusion;
	}
	
	
	public Long getOverallOrganization() {
		return OverallOrganization;
	}
	
	
	public void setOverallOrganization(Long overallOrganization) {
		OverallOrganization = overallOrganization;
	}
	
    

	public Long getAppropriateforSAC() {
		return AppropriateforSAC;
	}
	
    

	public void setAppropriateforSAC(Long appropriateforSAC) {
		AppropriateforSAC = appropriateforSAC;
	}
	
	public Long getStyleandClarityofPaper() {
		return StyleandClarityofPaper;
	}
	
	public void setStyleandClarityofPaper(Long styleandClarityofPaper) {
		StyleandClarityofPaper = styleandClarityofPaper;
	}
	
	public Long getOriginalityofContent() {
		return OriginalityofContent;
	}
	
	public void setOriginalityofContent(Long originalityofContent) {
		OriginalityofContent = originalityofContent;
	}
	

	public Long getRefereesConfidenceinPapersSubject() {
		return RefereesConfidenceinPapersSubject;
	}
    

	public void setRefereesConfidenceinPapersSubject(Long refereesConfidenceinPapersSubject) {
		RefereesConfidenceinPapersSubject = refereesConfidenceinPapersSubject;
	}
	
	
	
	public Long getOverallRecommendation() {
		return OverallRecommendation;
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
		OverallRecommendation = overallRecommendation;
	}
	

    

	public String getComments() {
		return comments;
	}
	
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	 
	
	public String getConfidentialComments() {
		return ConfidentialComments;
	}
	
	public void setConfidentialComments(String confidentialComments) {
		ConfidentialComments = confidentialComments;
	}

	 
	public Review(Rkey rid, Long technicalContentandAccuracy, Long significanceoftheWork,
			Long appropriateTitleLongroductionandConclusion, Long overallOrganization, Long appropriateforSAC,
			Long styleandClarityofPaper, Long originalityofContent, Long refereesConfidenceinPapersSubject,
			Long overallRecommendation, String comments, String confidentialComments, String decision) {
		super();
		this.rid = rid;
		this.TechnicalContentandAccuracy = technicalContentandAccuracy;
		this.SignificanceoftheWork = significanceoftheWork;
		this.AppropriateTitleLongroductionandConclusion = appropriateTitleLongroductionandConclusion;
		this.OverallOrganization = overallOrganization;
		this.AppropriateforSAC = appropriateforSAC;
		this.StyleandClarityofPaper = styleandClarityofPaper;
		this.OriginalityofContent = originalityofContent;
		this.RefereesConfidenceinPapersSubject = refereesConfidenceinPapersSubject;
		this.OverallRecommendation = overallRecommendation;
		this.comments = comments;
		this.ConfidentialComments = confidentialComments;
		this.decision = decision;
	}
	
	
	
	@Override
	public String toString() {
		return "Review [rid=" + rid + ", TechnicalContentandAccuracy=" + TechnicalContentandAccuracy
				+ ", SignificanceoftheWork=" + SignificanceoftheWork + ", AppropriateTitleLongroductionandConclusion="
				+ AppropriateTitleLongroductionandConclusion + ", OverallOrganization=" + OverallOrganization
				+ ", AppropriateforSAC=" + AppropriateforSAC + ", StyleandClarityofPaper=" + StyleandClarityofPaper
				+ ", OriginalityofContent=" + OriginalityofContent + ", RefereesConfidenceinPapersSubject="
				+ RefereesConfidenceinPapersSubject + ", OverallRecommendation=" + OverallRecommendation + ", comments="
				+ comments + ", ConfidentialComments=" + ConfidentialComments + ", decision=" + decision + "]";
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