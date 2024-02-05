package reviewer.model;

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
@Table(name="review")
public class Review 
{
	
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long rid;
       private Long TechnicalContentandAccuracy;	
       private Long SignificanceoftheWork;	
       private  Long AppropriateTitleLongroductionandConclusion;	
       private Long OverallOrganization;
       private Long AppropriateforSAC;	
       private Long StyleandClarityofPaper;	
       private Long OriginalityofContent;	
       private Long RefereesConfidenceinPapersSubject;	
       private Long OverallRecommendation;
       private String comments;
       private String ConfidentialComments;
       private String decision;
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


	
	public Review(Long rid, Long technicalContentandAccuracy, Long significanceoftheWork,
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
		// TODO Auto-generated constructor stub
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	   
}
