package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    needsRevision = true;
  }

  public boolean getNeedsRevision() {
    return needsRevision;
  }

  public Object getMetaData() {
    // Implementation
    return null;
  }

  public void setDeadline() {
    // Implementation
  }

  public String viewReview() {
    String review = "";
    review += "Review ID: " + reviewID + "\n";
    review += "PCM: " + pcm + "\n";
    review += "Body: " + body + "\n";
    review += "Score: " + score + "\n";
    return review;
  }

  public Object getSubject(UUID id) {
    if (this.reviewID.equals(id)) {
      return this;
    }
    return null;
  }
  public String toString() {
    return "{" +
            "\"reviewID\": \"" + reviewID + "\"," +
            "\"pcm\": \"" + pcm + "\"," +
            "\"body\": \"" + body + "\"," +
            "\"score\": " + score + "," +
            "\"needsRevision\": " + needsRevision + "" +
            "}";
  }
}