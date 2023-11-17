package com.model;

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
  private Submission previousSubmission;


  public Submission() {
    // Implementation
  }

  public Submission(UUID submissionID, String title, List<String> authors, int submissionVersion,
      List<Review> reviews, Rating rating, boolean rateStatus, Path filePath, Submission previousSubmission) {
    this.submissionID = submissionID;
    this.title = title;
    this.authors = authors;
    this.submissionVersion = submissionVersion;
    this.reviews = reviews;
    this.rating = rating;
    this.rateStatus = rateStatus;
    this.filePath = filePath;
    this.previousSubmission = previousSubmission;
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
}