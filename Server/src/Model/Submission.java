package Model;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class Submission {
  private String submissionID;
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

  public Submission(String submissionID, String title, List<String> authors, int submissionVersion,
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

public Object getSubject(UUID id) {
    return null;
}
}