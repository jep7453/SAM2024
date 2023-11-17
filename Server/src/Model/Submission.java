package Model;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class Submission {
  private UUID submissionID;
  private String title;
  private List<String> authors;
  private int submissionVersion;
  private List<Review> reviews;
  private Rating rating;
  private boolean rateStatus;
  private Path filePath;
  private UUID previousSubmission;

  private boolean mostRecent;


  public Submission() {
    // Implementation
  }

  public Submission(String title, List<String> authors, Path filePath, int submissionVersion, UUID previousSubmission) {
    this.submissionID = UUID.randomUUID();
    this.title = title;
    this.authors = authors;
    this.filePath = filePath;
    this.submissionVersion = submissionVersion;
    this.previousSubmission = previousSubmission;
    this.mostRecent = true;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public UUID getSubmissionID() {
    return submissionID;
  }

  public UUID getPreviousSubmission() {
    return previousSubmission;
  }

  /**
   * Returns the mostRecent status of the submission
   * Used to see if this submission is at the head of the submission chain
   * @return mostRecent
   */
  public boolean isMostRecent() {
    return mostRecent;
  }

  /**
   * Sets the mostRecent status of the submission
   * To be used when a new version of the submission is created
   * @param mostRecent
   */
  public void setMostRecent(boolean mostRecent) {
    this.mostRecent = mostRecent;
  }

  public int getSubmissionVersion() {
    return submissionVersion;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  /**
   * Adds a review to the list of reviews
   * @param review
   */
  public void addReview(Review review) {
    reviews.add(review);
  }

  public void submitPaper() {
    // Implementation
  }

  public List<String> getSubmissionHistory() {
    // Implementation
    return null;
  }

  public List<Review> getReviews() {
    // Implementation
    return null;
  }

  public void markCompleted() {
    // Implementation
  }

  public void printPaper() {
    // Implementation
  }

  public Object getMetaData() {
    // Implementation
    return null;
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public static Submission fromJson(String json) {
    // Implementation
    return null;
  }

public Object getSubject(UUID id) {
    return null;
}
}