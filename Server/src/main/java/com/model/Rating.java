
package com.model;

import java.util.UUID;

public class Rating {
  private UUID ratingID;
  private User pcc; // Assuming pcc is a type of User
  private String body;
  private int score;

  public Rating() {
    // Implementation
  }

  public Rating(UUID ratingID, User pcc, String body, int score) {
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