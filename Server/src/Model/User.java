package Model;


import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class User {
  private String userID;
  private String username;
  private String password;
  private String name;
  private EnumSet<UserRole> possibleRoles;
  private UserRole currentRole;
  private List<Notification> notifications;
  private List<Submission> submissions;
  private Map<Submission, Review> assignedReviews;
  private Map<Submission, Rating> assignedRating;

  public User() {
    // Implementation
  }

  public User(String userID, String username, String password, String name, EnumSet<UserRole> possibleRoles,
      UserRole currentRole, List<Notification> notifications, List<Submission> submissions,
      Map<Submission, Review> assignedReviews, Map<Submission, Rating> assignedRating) {
    this.userID = userID;
    this.username = username;
    this.password = password;
    this.name = name;
    this.possibleRoles = possibleRoles;
    this.currentRole = currentRole;
    this.notifications = notifications;
    this.submissions = submissions;
    this.assignedReviews = assignedReviews;
    this.assignedRating = assignedRating;
  }

  public String login(String username, String password) {
    // Implementation
    return null;
  }

  public void checkNotifications() {
    // Implementation
  }

  public Object getSubject() {
    // Implementation
    return null;
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public static User fromJson(String json) {
    // Implementation
    return null;
  }
}
