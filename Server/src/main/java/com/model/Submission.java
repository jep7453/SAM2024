package com.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Submission{
  private UUID submissionID;
  @JsonProperty("title")
  private String title;
  @JsonProperty("authors")
  private List<String> authors;
  @JsonProperty("submissionVersion")
  private int submissionVersion;
  @JsonProperty("reviews")
  private List<Review> reviews;
  @JsonProperty("rating")
  private Rating rating;
  @JsonProperty("rateStatus")
  private boolean rateStatus;
  private Path filePath;
  @JsonProperty("previousSubmission")
  private Submission previousSubmission;

  private boolean mostRecent;

  public Submission(String title, List<String> authors, Path filePath, int submissionVersion, Submission previousSubmission) {
    this.submissionID = UUID.randomUUID();
    this.title = title;
    this.authors = authors;
    this.filePath = filePath;
    this.submissionVersion = submissionVersion;
    this.previousSubmission = previousSubmission;
    this.mostRecent = true;
  }
  /**
   * =================================
   * Json -> Java
   */
  public Submission() {
  }

  @JsonProperty("submissionID")
  public void setSubmissionID(String submissionID) {
    this.submissionID = UUID.fromString(submissionID);
  }

  @JsonProperty("filePath")
  public void setFilePath(String filePath) {
    this.filePath = Paths.get(filePath);
  }
  /**
   * =================================
   */

  public String getTitle() {
    return title;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public UUID getSubmissionID() {
    return submissionID;
  }

  public Submission getPreviousSubmission() {
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

  public Rating getRating() {
    return rating;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void markCompleted() {
    // Implementation
  }

  public void printPaper() {

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
 /**
   * getSubject: 
   * The client has the attribute subject this is the id for the object that further commands will be executed on this id is passed along with every command
   * getSubject finds the object that the id references and returns it so commands can be executed
   *
   * @param id the id of the object being searched for
   * @return this/Review/Rating or NULL if unsuccessful (would indicate an error)
   */
public Object getSubject(UUID id) {
    /* check self */
    if (this.submissionID == id) {
      return this;
    }
    Object subject;
    /* check reviews */
    for (Review review : reviews) {
      subject = review.getSubject(id);
      if (subject != null) {
        return subject;
      }
    }
    /* check rating */
    subject = rating.getSubject(id);
    if (subject != null) {
        return subject;
    }
    /* check previous submission (this getSubject is recursive) */
    subject = previousSubmission.getSubject(id);
    if (subject != null) {
        return subject;
    }
    return null;
  }
  @Override
  public String toString() {
      return "Submission {" +
              "submissionID=" + submissionID +
              ", title='" + title + '\'' +
              ", authors=" + authors +
              ", submissionVersion=" + submissionVersion +
              ", reviews=" + reviews +
              ", rating=" + rating +
              ", rateStatus=" + rateStatus +
              ", filePath=" + filePath +
              ", previousSubmission=" + previousSubmission +
              '}';
  }
}