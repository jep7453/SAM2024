package com.model;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.text.SimpleDateFormat;

public class Notification {
  private UUID notificationID;
  private String alert;
  private Date deadline;

  private Date dateCreated;


  public Notification(String alert, String deadline, String dateCreated ) throws ParseException {
    this.alert = alert;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    if (deadline == null) {
      this.deadline = null;
    }
    else {
      Date date = formatter.parse(deadline);
      this.deadline = date;
    }
    Date date = formatter.parse(dateCreated);
    this.deadline = date;
  }


  public Notification() {
    // Implementation
  }

  public boolean isTriggered() {
    if (this.deadline == null) {
      return true;
    }
    Date date = new Date();
    if (date.after(this.deadline)) {
      return true;
    }
    return false;
  }

  public String toJson() {
    // Implementation
    return null;
  }

  public static Notification fromJson(String json) {
    // Implementation
    return null;
  }


  public Object getSubject(UUID id) {
    if (this.notificationID == id) {
      return this;
    }
    return null;
  }
}