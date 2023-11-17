package Model;

import java.util.Date;

public class Notification {
  private String alert;
  private Date deadline;


public Notification(String alert, Date deadline) {
    this.alert = alert;
    this.deadline = deadline;
  }


  public Notification() {
    // Implementation
  }

  public void makeNotification() {
    // Implementation
  }

  public String isTriggered() {
    // Implementation
    return null;
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public static Notification fromJson(String json) {
    // Implementation
    return null;
  }
}