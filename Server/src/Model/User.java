package Model;


import java.nio.file.Path;
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
  /* The submissions that the PCM has requested to review */
  private List<Submission> requestedSubmissions;
  /* The reviews that the PCM is assigned these are removed once a report is generated and sent to the SUBMITTER */
  private Map<UUID, UUID> assignedReviews;
  /* The  rateings that the PCC is assigned these are removed once a report is generated and sent to the SUBMITTER*/
  private Map<UUID, UUID> assignedRating;

  public User() {
    // Implementation
  }

  public User(UUID userID, String username, String password, String name, EnumSet<UserRole> possibleRoles,
      UserRole currentRole, List<Notification> notifications, List<Submission> submissions,
      Map<UUID, UUID> assignedReviews, Map<UUID, UUID> assignedRating) {
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

  /**
   * Submits a paper to the system, saving it to the user's list of submissions.
   *
   * @param title     The title of the paper.
   * @param authors   The list of authors of the paper.
   * @param filePath  The file path to the paper.
   * @return True if submission is successful, false otherwise.
   */
  public boolean submitPaper(String title, List<String> authors, Path filePath) {
    Submission submission;
    if (this.currentRole == UserRole.SUBMITTER) {
      return false;
    }
    submission = new Submission(title, authors,filePath, 1, null);
    submissions.add(submission);
    return true;
  }

  /**
   * Updates the version of an already submitted paper
   *
   * @param title        The title of the paper.
   * @param authors      The list of authors of the paper.
   * @param filePath     The file path to the paper.
   * @param submissionID The ID of the submission to be updated.
   * @return True if update is successful, false otherwise.
   */
  public boolean updatePaper(String title, List<String> authors, Path filePath, UUID submissionID) {
    Submission submission;
    if (this.currentRole != UserRole.SUBMITTER) {
      return false;
    }
    if (getSubject(submissionID) != null) {
      return false;
    }
    Submission previousSubmission = (Submission) getSubject(submissionID);
    int submissionVersion = previousSubmission.getSubmissionVersion() + 1;
    previousSubmission.setMostRecent(false);
    submission = new Submission(title, authors, filePath, submissionVersion, previousSubmission.getSubmissionID());
    submissions.add(submission);
    return true;
  }

  /**
   * Creates a rating based on the parameters
   * Adds the rating to the submission
   * Adds the ratingID to the assignedRating map, under the submissionID key
   *
   * @param submissionID The ID of the submission to be rated.
   * @param ratingScore  The score to be given to the paper.
   * @param body         The body of the rating.
   * @return True if rating is successful, false otherwise.
   */
  public boolean ratePaper(UUID submissionID, int ratingScore, String body) {
    if (this.currentRole == UserRole.PCC) {
      return false;
    }
    Submission submission = (Submission) getSubject(submissionID);
    Rating rating = new Rating(userID, body, ratingScore);
    submission.setRating(rating);
    assignedRating.put(submissionID, rating.getRatingID());
    return true;
  }

  /**
   * Creates a review based on the parameters
   * Adds the review to the list of reviews in the submission
   * Adds the reviewID to the assignedReview map, under the submissionID key
   *
   * @param submissionID The ID of the submission to be reviewed.
   * @param reviewScore  The score to be given to the paper.
   * @param body         The body of the review.
   * @return True if review is successful, false otherwise.
   */
  public boolean reviewPaper(UUID submissionID, int reviewScore, String body) {
    if (this.currentRole == UserRole.PCM) {
      return false;
    }
      Submission submission = (Submission) getSubject(submissionID);
      Review review = new Review(userID, body, reviewScore);
      submission.addReview(review);
      assignedReviews.put(submissionID, review.getReviewID());
      return true;
  }

  /**
   * Assigns a paper to a PCM in the system for them to review it
   * Only the PCC can assign papers
   *
   * @param submissionID The ID of the submission to be assigned.
   * @param userID       The ID of the user to whom the paper is to be assigned.
   * @return True if assignment is successful, false otherwise.
   */
  public boolean assignPaper(UUID submissionID, UUID userID) {
    if (this.currentRole != UserRole.PCC) {
      return false;
    }
    Submission submission = (Submission) getSubject(submissionID);
    User user = (User) getSubject(userID);
    if (submission == null || user == null) {
      return false;
    }
    user.addAssignedReview(submissionID);
    return true;
  }

  /**
   * Adds a review assignment to this user.
   * Only should happen to PCM users.
   *
   * @param submissionID The ID of the submission to be reviewed by this user.
   */
  public void addAssignedReview(UUID submissionID) {
    assignedReviews.put(submissionID, null);
  }

  /**
   * Adds a paper to a PCMs list of requested papers to review
   *
   * @param submissionID The ID of the submission for which a review is requested.
   * @return True if request is successful, false otherwise.
   */
  public boolean requestReview(UUID submissionID) {
    if (this.currentRole != UserRole.PCM) {
      return false;
    }
    Submission submission = (Submission) getSubject(submissionID);
    if (submission == null) {
      return false;
    }
    requestedSubmissions.add(submission);
    return true;
  }

  /**
   * Attempts to log in a user with the provided credentials and role.
   * Checks if the provided username, password, and userRole match the user's stored credentials.
   * If the credentials match, the current role of the user is set to the provided role, and the user's ID is returned.
   * If the credentials do not match, null is returned.
   *
   * @param username The username to be checked against the user's username.
   * @param password The password to be checked against the user's password.
   * @param userRole The UserRole to be checked against the user's possible roles.
   * @return The UUID of the user if login is successful; otherwise, null.
   */
  public UUID login(String username, String password, UserRole userRole) {
    if(this.username.equals(username) && this.password.equals(password) && this.possibleRoles.contains(userRole)) {
      this.currentRole = userRole;
      return this.userID;
    }
    else {
      return null;
    }
  }

  private void checkNotifications() {
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