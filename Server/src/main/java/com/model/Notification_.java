package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Notification_ {
  private UUID notificationID;
  @JsonProperty("alert")
  private String alert;
  private Date deadline;

  private Date dateCreated;


  public Notification_(String alert, String deadline, String dateCreated ) throws ParseException {
    this.notificationID = UUID.randomUUID();
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

  public Object getSubject(UUID id) {
    if (this.notificationID == id) {
      return this;
    }
    return null;
  }

  @Override
  public String toString() {
    return "{" +
          "\"notificationID\": \"" + notificationID + "\"," +
          "\"alert\": \"" + alert + "\"," +
          "\"deadline\": \"" + deadline + "\"" +
          "}";
  }
}