package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
  private UUID reviewID;
  private UUID pcm; // Assuming pcm is a type of User
  private String body;
  private int score;
  private boolean needsRevision;

  public Review(UUID pcm, String body, int score, boolean needsRevision) {
    this.reviewID = UUID.randomUUID();
    this.pcm = pcm;
    this.body = body;
    this.score = score;
    this.needsRevision = needsRevision;
  }

  public Review(
      @JsonProperty("reviewID") UUID reviewID,
      @JsonProperty("pcm") UUID pcm,
      @JsonProperty("body") String body,
      @JsonProperty("score") int score,
      @JsonProperty("needsRevision") boolean needsRevision) {
    this.reviewID = reviewID;
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