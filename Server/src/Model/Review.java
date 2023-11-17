package Model;

import java.util.UUID;

public class Review {
  private UUID reviewID;
  private UUID pcmID; // Assuming pcm is a type of User
  private String body;
  private int score;
  private boolean needsRevision;

  public Review() {
    // Implementation
  }

  public Review( UUID pcm, String body, int score) {
    this.reviewID = UUID.randomUUID();
    this.pcmID = pcm;
    this.body = body;
    this.score = score;
    this.needsRevision = false;
  }

  public UUID getReviewID() {
    return reviewID;
  }

  public void reviseReview() {
    // Implementation
  }

  public Object getMetaData() {
    // Implementation
    return null;
  }

  public void setDeadline() {
    // Implementation
  }

  public void printReview() {
    // Implementation
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public static Review fromJson(String json) {
    // Implementation
    return null;
  }
}