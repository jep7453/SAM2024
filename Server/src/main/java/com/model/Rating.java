
package com.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  public void setContent(int score, String body) {
    this.score = score;
    this.body = body;
  }

  public UUID getRatingID() {
    return this.ratingID;
  }

  public String viewRating() {
    String rating = "";
    rating += "Rating ID: " + this.ratingID + "\n";
    rating += "PCC: " + this.pcc + "\n";
    rating += "Body: " + this.body + "\n";
    rating += "Score: " + this.score + "\n";
    return rating;
  }

  public Object getSubject(UUID id) {
    if (this.ratingID.equals(id)) {
      return this;
    }
    return null;
  }
  @Override
  public String toString() {
    return "{" +
          "\"ratingID\": \"" + ratingID + "\"," +
          "\"pcc\": \"" + pcc + "\"," +
          "\"body\": \"" + body + "\"," +
          "\"score\": " + score + "" +
          "}";
  }
}