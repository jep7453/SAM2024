package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notification_ {
  private UUID notificationID;
  @JsonProperty("alert")
  private String alert;
  private Date deadline;


  public Notification_(String alert, Date deadline) {
    this.notificationID = UUID.randomUUID();
    this.alert = alert;
    this.deadline = deadline;
  }
  /**
   * =================================
   * Json -> Java
   */
  public Notification_() {
    
  }
  @JsonProperty("notificationID")
  public void setNotificationID(String notificationID) {
    this.notificationID = UUID.fromString(notificationID);
  }
  @JsonProperty("deadline")
  public void setDeadline(String deadline) {
    this.deadline = new Date();
    //TODO: This is not properly done
  }
  /**
   * =================================
   */

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

  public Object getSubject(UUID id) {
    if (this.notificationID == id) {
      return this;
    }
    return null;
  }

  @Override
  public String toString() {
      return "Notification {" +
              "notificationID=" + notificationID +
              ", alert='" + alert + '\'' +
              ", deadline=" + deadline +
              '}';
  }
}