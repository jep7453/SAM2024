package com.model;

import java.util.UUID;

public class Review {
  private UUID reviewID;
  private User pcm; // Assuming pcm is a type of User
  private String body;
  private int score;
  private boolean needsRevision;

  public Review() {
    // Implementation
  }

  public Review(User pcm, String body, int score, boolean needsRevision) {
    this.reviewID = UUID.randomUUID();
    this.pcm = pcm;
    this.body = body;
    this.score = score;
    this.needsRevision = needsRevision;
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

  public Object getSubject(UUID id) {
    if (this.reviewID == id) {
      return this;
    }
    return null;
  }
}