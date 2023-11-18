
package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
  private UUID ratingID;
  private UUID pcc; // Assuming pcc is a type of User
  private String body;
  private int score;

  public Rating(UUID pcc, String body, int score) {
    this.ratingID = UUID.randomUUID();
    this.pcc = pcc;
    this.body = body;
    this.score = score;
  }

  public Rating(
        @JsonProperty("ratingID") UUID ratingID,
        @JsonProperty("pcc") UUID pcc,
        @JsonProperty("body") String body,
        @JsonProperty("score") int score) {
      this.ratingID = ratingID;
      this.pcc = pcc;
      this.body = body;
      this.score = score;
    }

  public void setDeadline() {
    // Implementation
  }

  public void printRating() {
    // Implementation
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public void setContent(int score, String body) {
    this.score = score;
    this.body = body;
  }

  public UUID getRatingID() {
    return this.ratingID;
  }

  public static Rating fromJson(String json) {
    // Implementation
    return null;
  }

  public Object getSubject(UUID id) {
    if (this.ratingID == id) {
      return this;
    }
    return null;
  }
}