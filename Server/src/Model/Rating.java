package Model;

import java.util.UUID;

public class Rating {
  private UUID ratingID;
  private UUID pccID; // Assuming pcc is a type of User
  private String body;
  private int score;

  public Rating() {
    // Implementation
  }

  public Rating(UUID pcc, String body, int score) {
    this.ratingID = UUID.randomUUID();
    this.pccID = pcc;
    this.body = body;
    this.score = score;
  }

  public UUID getRatingID() {
    return ratingID;
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
}