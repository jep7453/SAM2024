package Model;


import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class User {
  private UUID userID;
  private String username;
  private String password;
  private String name;
  private EnumSet<UserRole> possibleRoles;
  private UserRole currentRole;
  private List<Notification> notifications;
  /* List of unique submissions each submission is the head of a linked list of past submissions (this is how version control is handled) */
  private List<Submission> submissions;
  /* The reviews that the PCM is assigned these are removed once a report is generated and sent to the SUBMITTER */
  private Map<Submission, Review> assignedReviews;
  /* The  rateings that the PCC is assigned these are removed once a report is generated and sent to the SUBMITTER*/
  private Map<Submission, Rating> assignedRating;

  public User() {
    // Implementation
  }

  public User(UUID userID, String username, String password, String name, EnumSet<UserRole> possibleRoles,
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

  public UUID login(String username, String password, UserRole userRole) {
    // Implementation
    return null;
  }

  private void checkNotifications() {
    // Implementation
  }

  /**
   * getSubject: 
   * The client has the attribute subject this is the id for the object that further commands will be executed on this id is passed along with every command
   * getSubject finds the object that the id references and returns it so commands can be executed
   *
   * @param id the id of the object being searched for
   * @return this/Notification/Review/Rating/Submission or NULL if unsuccessful (would indicate an error)
   */
  public Object getSubject(UUID id) {
    // Implementation
    if (this.userID == id) {
      return this;
    }
    Object subject;
    /* All roles have access to notifications */
    for (Notification notification : notifications) {
      subject = notification.getSubject(id);
      if (subject != null) {
        return subject;
      }
    }
    // if (this.currentRole == UserRole.SUBMITTER) {
    //   for (Submission submission : submissions) {
    //     subject = submission.getSubject(id);
    //     if (subject != null) {
    //       return subject;
    //     }
    //   }
    // } else if (this.currentRole == UserRole.PCM) {
    //     for (Review notification : notifications) {
          
    //     } assignedReviews.values().getSubject(id);
    //     if (subject != null) {
    //       return subject;
    //     }

    // } else if (this.currentRole == UserRole.PCC) {
    // }
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
