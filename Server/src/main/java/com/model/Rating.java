
package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
  private UUID ratingID;
  private UUID pcc; // Assuming pcc is a type of User
  @JsonProperty("body")
  private String body;
  @JsonProperty("score")
  private int score;

  public Rating(UUID pcc, String body, int score) {
    this.ratingID = UUID.randomUUID();
    this.pcc = pcc;
    this.body = body;
    this.score = score;
  }

  /**
   * =================================
   * Json -> Java
   */
  public Rating() {
  }
  
  @JsonProperty("ratingID")
  public void setRatingID(String ratingID) {
    this.ratingID = UUID.fromString(ratingID);
  }
  @JsonProperty("pcc")
  public void setPcc (String pcc) {
    this.pcc = UUID.fromString(pcc);
  }
  /**
   * ================================
   */
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

  public Object getSubject(UUID id) {
    if (this.ratingID == id) {
      return this;
    }
    return null;
  }
  @Override
  public String toString() {
      return "Rating {" +
              "ratingID=" + ratingID +
              ", pcc=" + pcc +
              ", body='" + body + '\'' +
              ", score=" + score +
              '}';
  }
}