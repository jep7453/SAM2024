package com.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;
/**
 * System 
 */
public class System {
  private List<User> users;
  private String jsonFilePath = "../../resources/SAM2024.json";
  /**
   * System
   * 
   * When system is launched all data stored in Json form will be converted into objects
   */
  public System() {
    // Implementation
    
  }
  /**
   * 
   * @param user
   */
  public void addUser(User user) {
    // Implementation
  }
  /**
   * Login:
   * Sees if a user with the provided information exists in the system if so that user's id is returned
   * The returned id is stored client side and is passed along with every command
   * @param username The user name entered for login attempt 
   * @param password The password entered for login attempt
   * @param userRoleString The user role that is entered for login attempt
   * @return If all the values passed in match one of the User objects stored in the system then an userID will be returned otherwise NULL
   */
  public UUID login(String username, String password, String userRoleString) {
    UUID attempt;
    for (User user : users) {
      attempt = user.login(username, password, UserRole.valueOf(userRoleString));
      if (attempt != null) {
        return attempt;
      }
    }
    return null;
  }
  /**
   * getSubject: 
   * The client has the attribute subject this is the id for the object that further commands will be executed on this id is passed along with every command
   * getSubject finds the object that the id references and returns it so commands can be executed
   * 
   * different from the other getSubject methods defined in the other objects this method also retrieves the User as defined by the currentUser attribute stored in the client this too is passed with every command
   * Another difference is that this getSubject is the only getSubject that admin concrete commands interface with
   * @param id the id of the object being searched for
   * @return User/Notification/Review/Rating/Submission or NULL if unsuccessful (would indicate an error)
   */
  public Object getSubject (UUID id) {
    Object subject;
    for (User user : users) {
      subject = user.getSubject(id);
      if (subject != null) {
        return subject;
      }
    }
    return null;
  }

  /**
   * Converts the objects that make up the system into json so that information can persist 
   * @return
   */
  public String toJson() {
    // Implementation
    return null;
  }
  /**
   * Converts json representation of the system into objects
   * @param json
   * @return
   */
  public void fromJson(String json) {
    // Implementation
    // ObjectMapper objectMapper = new ObjectMapper();

  }
}