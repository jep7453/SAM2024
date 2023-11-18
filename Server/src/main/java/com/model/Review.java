package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
  private UUID reviewID;
  private UUID pcm; // Assuming pcm is a type of User
  @JsonProperty("body")
  private String body;
  @JsonProperty("score")
  private int score;
  @JsonProperty("needsRevision")
  private boolean needsRevision;

  public Review(UUID pcm, String body, int score, boolean needsRevision) {
    this.reviewID = UUID.randomUUID();
    this.pcm = pcm;
    this.body = body;
    this.score = score;
    this.needsRevision = needsRevision;
  }
  /**
   * =================================
   * Json -> Java
   */
  public Review() {
  }
  @JsonProperty("reviewID")
  public void setReviewID(String reviewID) {
    this.reviewID = UUID.fromString(reviewID);
  }
  @JsonProperty("pcm")
  public void setPcm(String pcm) {
    this.pcm = UUID.fromString(pcm);
  }
  /**
   * =================================
   */

  public void setContent(int score, String body) {
    this.score = score;
    this.body = body;
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

  public Object getSubject(UUID id) {
    if (this.reviewID == id) {
      return this;
    }
    return null;
  }
  public String toString() {
    return "Review {" +
            "reviewID=" + reviewID +
            ", pcm=" + pcm +
            ", body='" + body + '\'' +
            ", score=" + score +
            ", needsRevision=" + needsRevision +
            '}';
  }
}