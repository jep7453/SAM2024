package com.model;


import java.nio.file.Path;

import javax.management.Notification;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User{
  private UUID userID;
  @JsonProperty("username")
  private String username;
  @JsonProperty("password")
  private String password;
  @JsonProperty("name")
  private String name;
  @JsonProperty("possibleRoles")
  private EnumSet<UserRole> possibleRoles;
  @JsonProperty("currentRole")
  private UserRole currentRole;
  @JsonProperty("notifications")
  private List<Notification_> notifications;
  /* List of unique submissions each submission is the head of a linked list of past submissions (this is how version control is handled) */
  @JsonProperty("submissions")
  private List<Submission> submissions;
  /* The submissions that the PCM has requested to review */
  @JsonProperty("requestedSubmissions")
  private List<UUID> requestedSubmissions;
  /* The reviews that the PCM is assigned these are removed once a report is generated and sent to the SUBMITTER */
  private Map<UUID, UUID> assignedReviews = new HashMap<>();
  /* The  rateings that the PCC is assigned these are removed once a report is generated and sent to the SUBMITTER*/
  private Map<UUID, UUID> assignedRatings = new HashMap<>();

  public User(UUID userID, String username, String password, String name, EnumSet<UserRole> possibleRoles,
      UserRole currentRole, List<Notification_> notifications, List<Submission> submissions,
      Map<UUID, UUID> assignedReviews, Map<UUID, UUID> assignedRatings) {
    this.userID = userID;
    this.username = username;
    this.password = password;
    this.name = name;
    this.possibleRoles = possibleRoles;
    this.currentRole = currentRole;
    this.notifications = notifications;
    this.submissions = submissions;
    this.assignedReviews = assignedReviews;
    this.assignedRatings = assignedRatings;
  }
  /**
   * =================================
   * Json -> Java
   */
  public User() {
  }
  @JsonProperty("userID")
  public void setUserID(String userID) {
    this.userID = UUID.fromString(userID);
  }
  @JsonProperty("assignedReviews")
  public void setAssignedReviews(List<Map<String, String>> assignedReviews) {
    for (Map<String, String> reviewMapping : assignedReviews) {
      // Assuming the keys in the map are "submissionID" and "reviewID"
      String submissionIDString = reviewMapping.get("submissionID");
      String reviewIDString = reviewMapping.get("reviewID");

      // Convert the strings to UUID
      UUID submissionID = UUID.fromString(submissionIDString);
      UUID reviewID = UUID.fromString(reviewIDString);

      // Add the mapping to the map
      this.assignedReviews.put(submissionID, reviewID);
    }
  }
  @JsonProperty("assignedRatings")
  public void setAssignedRatings(List<Map<String, String>> assignedRatings) {
    for (Map<String, String> ratingMapping : assignedRatings) {
      // Assuming the keys in the map are "submissionID" and "reviewID"
      String submissionIDString = ratingMapping.get("submissionID");
      String ratingIDString = ratingMapping.get("ratingID");

      // Convert the strings to UUID
      UUID submissionID = UUID.fromString(submissionIDString);
      UUID ratingID = UUID.fromString(ratingIDString);

      // Add the mapping to the map
      this.assignedRatings.put(submissionID, ratingID);
    }
  }
  /**
   * =================================
   */

  /**
   * Submits a paper to the system, saving it to the user's list of submissions.
   *
   * @param title     The title of the paper.
   * @param authors   The list of authors of the paper.
   * @param filePath  The file path to the paper.
   * @return True if submission is successful, false otherwise.
   */
  public boolean submitPaper(String title, List<String> authors, Path filePath) throws ParseException {
    Submission submission;
    if (this.currentRole == UserRole.SUBMITTER) {
      return false;
    }
    submission = new Submission(title, authors,filePath, 1, null);
    submissions.add(submission);

    Date date = new Date();
    String strDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
    Notification_ notification = new Notification_(("Notification: Submission " + submission.getSubmissionID()
            + " has been submitted"),null,strDate);

    Root root = Root.getInstance();
    root.getPCC().notify(notification);

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
  public boolean updatePaper(String title, List<String> authors, Path filePath, UUID submissionID) throws ParseException {
    Submission submission;
    if (this.currentRole != UserRole.SUBMITTER) {
      return false;
    }
    if (getSubject(submissionID) != null) {
      return false;
    }
    Root root = Root.getInstance();
    Submission previousSubmission = (Submission) root.getSubject(submissionID);
    int submissionVersion = previousSubmission.getSubmissionVersion() + 1;
    previousSubmission.setMostRecent(false);
    submission = new Submission(title, authors, filePath, submissionVersion, previousSubmission);
    submissions.remove(previousSubmission);
    submissions.add(submission);

    Date date = new Date();
    String strDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
    Notification_ notification = new Notification_(("Notification: Submission " + submission.getSubmissionID()
            + " has been submitted"),null,strDate);

    root = Root.getInstance();
    root.getPCC().notify(notification);


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
    Root root = Root.getInstance();
    Submission submission = (Submission) root.getSubject(submissionID);
    Rating rating = submission.getRating();
    rating.setContent(ratingScore,body);
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
    Root root = Root.getInstance();
    Submission submission = (Submission) root.getSubject(submissionID);
    UUID reviewID = assignedReviews.get(submissionID);
    Review review = (Review) root.getSubject(reviewID);
    review.setContent(reviewScore,body);
    return true;
  }

  /**
   * Assigns a paper to a PCM in the system for them to review it
   * Only the PCC can assign papers
   *
   * @param submissionID The ID of the submission to be assigned.
   * @return True if assignment is successful, false otherwise.
   */
  public boolean assignPaperToPCM(UUID submissionID) throws ParseException {
    if (this.currentRole != UserRole.PCM) {
      return false;
    }
    Root root = Root.getInstance();
    Submission submission = (Submission) root.getSubject(submissionID);
    if (submission == null) {
      return false;
    }
    Review review = new Review(userID, null,0, false);
    submission.addReview(review);
    this.assignedReviews.put(submissionID, review.getReviewID());

    Date date = new Date();
    String strDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
    Notification_ notification = new Notification_(("Notification: Submission " + submission.getSubmissionID()
            + " has been assigned to you"),null,strDate);

    return true;
  }

  /**
   * Assigns a paper to a PCC in the system for them to rate it
   * Only the Admin can assign papers
   * @param submissionID
   * @return
   */
  public boolean assignPaperToPCC(UUID submissionID) {
    if (this.currentRole != UserRole.PCC) {
      return false;
    }
    Root root = Root.getInstance();
    Submission submission = (Submission) root.getSubject(submissionID);
    if (submission == null) {
      return false;
    }
    Rating rating = new Rating(userID, null,0);
    submission.setRating(rating);
    this.assignedRatings.put(submissionID, rating.getRatingID());
    return true;
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
    requestedSubmissions.add(submission.getSubmissionID());
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

  public List<Notification_> checkNotifications() {
    ArrayList triggeredNotifications = new ArrayList<>();
    for (Notification_ notification : notifications) {
      if (notification.isTriggered()) {
        triggeredNotifications.add(notification);
      }
    }
    notifications.removeAll(triggeredNotifications);
    return triggeredNotifications;
  }

  public void notify(Notification_ notification) {
    notifications.add(notification);
  }

  public EnumSet<UserRole> getPossibleRoles() {
    return possibleRoles;
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
    /* check self */
    if (this.userID == id) {
      return this;
    }
    Object subject;
    /* check notification */
    for (Notification_ notification : notifications) {
      subject = notification.getSubject(id);
      if (subject != null) {
        return subject;
      }
    }
    /* check submissions */
    for (Submission submission : submissions) {
      subject = submission.getSubject(id);
      if (subject != null) {
        return subject;
      }
    }
    return null;
  }

  @Override
public String toString() {
    return "{" +
            "\"userID\": \"" + userID + "\"," +
            "\"username\": \"" + username + "\"," +
            "\"password\": \"" + password + "\"," +
            "\"name\": \"" + name + "\"," +
            "\"possibleRoles\": " + handlePossibleRoles() + "," +
            "\"currentRole\": \"" + currentRole + "\"," +
            "\"notifications\": " + notifications + "," +
            "\"submissions\": " + submissions + "," +
            handleRequestedSubmissions() +
            "\"assignedReviews\": [" + getReviewMappingString(assignedReviews) + "]," +
            "\"assignedRatings\": [" + getRatingMappingString(assignedRatings) + "]" +
            "}";
}

private String handlePossibleRoles() {
    StringBuilder result = new StringBuilder();
    int i = 0;
    result.append("[");
    for (UserRole userRole : possibleRoles) {
        result.append("\"" + userRole.toString() + "\"");
        if (i < possibleRoles.size() - 1) {
            result.append(", ");
        }
        i++;
    }
    result.append("]");
    return result.toString();
}
private String handleRequestedSubmissions() {
    if (requestedSubmissions != null) {
        return "\"requestedSubmissions\": " + requestedSubmissions + ",";
    } return "";
}
private String getReviewMappingString(Map<UUID, UUID> map) {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<UUID, UUID> entry : map.entrySet()) {
        result.append("{\"submissionID\": \"")
                .append(entry.getKey())
                .append("\", \"reviewID\": \"")
                .append(entry.getValue())
                .append("\"}");
    }
    return result.toString();
}

private String getRatingMappingString(Map<UUID, UUID> map) {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<UUID, UUID> entry : map.entrySet()) {
        result.append("{\"submissionID\": \"")
                .append(entry.getKey())
                .append("\", \"ratingID\": \"")
                .append(entry.getValue())
                .append("\"}");
    }
    return result.toString();
    }

}

