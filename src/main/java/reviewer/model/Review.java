package reviewer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Entity class representing a review.
 *
 * This class defines the structure of a review, including various rating categories,
 * comments, and a decision based on the review.
 *
 * @author Attanti
 * @version 1.0
 * @since 2024-02-05
 */
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
    
       
       /**
        * Returns the technical content and accuracy rating.
        *
        * @return The technical content and accuracy rating.
        */
	public Long getTechnicalContentandAccuracy() {
		return TechnicalContentandAccuracy;
	}
	 /**
     * Sets the technical content and accuracy rating.
     *
     * @param technicalContentandAccuracy The technical content and accuracy rating to set.
     */
	public void setTechnicalContentandAccuracy(Long technicalContentandAccuracy) {
		TechnicalContentandAccuracy = technicalContentandAccuracy;
	}
	/**
     * Returns the significance of the work rating.
     *
     * @return The significance of the work rating.
     */
	public Long getSignificanceoftheWork() {
		return SignificanceoftheWork;
	}
	 /**
     * Sets the significance of the work rating.
     *
     * @param significanceoftheWork The significance of the work rating to set.
     */
	public void setSignificanceoftheWork(Long significanceoftheWork) {
		SignificanceoftheWork = significanceoftheWork;
	}
	/**
     * Returns the appropriate title, introduction, and conclusion rating.
     *
     * @return The appropriate title, introduction, and conclusion rating.
     */
	public Long getAppropriateTitleLongroductionandConclusion() {
		return AppropriateTitleLongroductionandConclusion;
	}
	/**
     * Sets the appropriate title, introduction, and conclusion rating.
     *
     * @param appropriateTitleLongroductionandConclusion The appropriate title, introduction, and conclusion rating to set.
     */

	public void setAppropriateTitleLongroductionandConclusion(Long appropriateTitleLongroductionandConclusion) {
		AppropriateTitleLongroductionandConclusion = appropriateTitleLongroductionandConclusion;
	}
	
	 /**
     * Returns the overall organization rating.
     *
     * @return The overall organization rating.
     */
	
	public Long getOverallOrganization() {
		return OverallOrganization;
	}
	
	/**
     * Sets the overall organization rating.
     *
     * @param overallOrganization The overall organization rating to set.
     */
	public void setOverallOrganization(Long overallOrganization) {
		OverallOrganization = overallOrganization;
	}
	
    /**
     * Returns the appropriateness for SAC rating.
     *
     * @return The appropriateness for SAC rating.
     */

	public Long getAppropriateforSAC() {
		return AppropriateforSAC;
	}
	
    /**
     * Sets the appropriateness for SAC rating.
     *
     * @param appropriateforSAC The appropriateness for SAC rating to set.
     */

	public void setAppropriateforSAC(Long appropriateforSAC) {
		AppropriateforSAC = appropriateforSAC;
	}
	 /**
     * Returns the style and clarity of the paper rating.
     *
     * @return The style and clarity of the paper rating.
     */
	public Long getStyleandClarityofPaper() {
		return StyleandClarityofPaper;
	}
	 /**
     * Sets the style and clarity of the paper rating.
     *
     * @param styleandClarityofPaper The style and clarity of the paper rating to set.
     */
	public void setStyleandClarityofPaper(Long styleandClarityofPaper) {
		StyleandClarityofPaper = styleandClarityofPaper;
	}
	 /**
     * Returns the originality of content rating.
     *
     * @return The originality of content rating.
     */
	public Long getOriginalityofContent() {
		return OriginalityofContent;
	}
	/**
     * Sets the originality of content rating.
     *
     * @param originalityofContent The originality of content rating to set.
     */
	public void setOriginalityofContent(Long originalityofContent) {
		OriginalityofContent = originalityofContent;
	}
	/**
     * Returns the referee's confidence in paper's subject rating.
     *
     * @return The referee's confidence in paper's subject rating.
     */

	public Long getRefereesConfidenceinPapersSubject() {
		return RefereesConfidenceinPapersSubject;
	}
    /**
     * Sets the referee's confidence in paper's subject rating.
     *
     * @param refereesConfidenceinPapersSubject The referee's confidence in paper's subject rating to set.
     */

	public void setRefereesConfidenceinPapersSubject(Long refereesConfidenceinPapersSubject) {
		RefereesConfidenceinPapersSubject = refereesConfidenceinPapersSubject;
	}
	
	/**
     * Returns the overall recommendation rating.
     *
     * @return The overall recommendation rating.
     */
	
	public Long getOverallRecommendation() {
		return OverallRecommendation;
	}
	/**
     * Sets the overall recommendation rating.
     *
     * @param overallRecommendation The overall recommendation rating to set.
     */

	public void setOverallRecommendation(Long overallRecommendation) {
		OverallRecommendation = overallRecommendation;
	}
	

    /**
     * Returns general comments on the review.
     *
     * @return General comments on the review.
     */

	public String getComments() {
		return comments;
	}
	
    /**
     * Sets general comments on the review.
     *
     * @param comments General comments on the review to set.
     */

	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	 /**
     * Returns confidential comments on the review.
     *
     * @return Confidential comments on the review.
     */
	
	public String getConfidentialComments() {
		return ConfidentialComments;
	}
	/**
     * Sets confidential comments on the review.
     *
     * @param confidentialComments Confidential comments on the review to set.
     */
	public void setConfidentialComments(String confidentialComments) {
		ConfidentialComments = confidentialComments;
	}

	  /**
     * Constructor with all fields.
     *
     * @param rid                                   The review ID.
     * @param technicalContentandAccuracy          Technical content and accuracy rating.
     * @param significanceoftheWork                Significance of the work rating.
     * @param appropriateTitleLongroductionandConclusion Appropriate title, introduction, and conclusion rating.
     * @param overallOrganization                  Overall organization rating.
     * @param appropriateforSAC                    Appropriateness for SAC rating.
     * @param styleandClarityofPaper               Style and clarity of the paper rating.
     * @param originalityofContent                 Originality of content rating.
     * @param refereesConfidenceinPapersSubject    Referee's confidence in paper's subject rating.
     * @param overallRecommendation                Overall recommendation rating.
     * @param comments                             General comments on the review.
     * @param confidentialComments                Confidential comments on the review.
     * @param decision                             Decision based on the review.
     */
	
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
	
	/**
     * Returns a string representation of the Review object.
     *
     * @return A string representation.
     */
	
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
	
	 /**
     * Default constructor.
     */
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
     * Returns the decision based on the review.
     *
     * @return The decision based on the review.
     */

	public String getDecision() {
		return decision;
	}
	 /**
     * Sets the decision based on the review.
     *
     * @param decision The decision based on the review to set.
     */
	public void setDecision(String decision) {
		this.decision = decision;
	}
	   
}
