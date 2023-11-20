package com.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.UserRole;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
/**
 * System 
 */
public class Root {
  private List<User> users;
  private String filePath = "C:\\Users\\happy\\IdeaProjects\\SAM2024\\server\\src\\main\\resources\\SAM2024.json";

  public static void main(String[] args) {
    Root s = Root.getInstance();
    //TODO Link to server controller
  }

  private static class SystemHelper {
    private static final Root INSTANCE;
    static {
      Root tempInstance = null;
      try {
        tempInstance = new Root();
      } catch (Exception e) {
        // TODO: handle exception
      }
      INSTANCE = tempInstance;
    }
  }
  /**
   * Root
   * 
   * When Root is launched all data stored in Json form will be converted into objects
   * @throws IOException
   * @throws JsonMappingException
   * @throws JsonParseException
   */
  private Root() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Path path = Paths.get(filePath);
    String jsonString = Files.readString(path);
    this.users = convertJsonToObject(jsonString, new TypeReference<List<User>>() {});
    // this.toJson();

  }

  private static <T> T convertJsonToObject(String json, TypeReference<T> typeReference) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(json, typeReference);
  }
  /**
   * This is used to access this object
   * @return
   */
  public static Root getInstance() {
    return SystemHelper.INSTANCE;
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

  public User getPCC() {
    for (User user : users) {
      if (user.getPossibleRoles().contains(UserRole.PCC)) {
        return user;
      }
    }
    return null;

  }

  public void addUser(String username, String password, String name, EnumSet<UserRole> possibleRoles) {
    User user = new User(username, password,name, possibleRoles);
    users.add(user);
  }

  public void deleteUser(UUID userID) {
    List<User> usersToRemove = new ArrayList<User>();
    for (User user : users) {
      if (user.getUserID().equals(userID)) {
        usersToRemove.add(user);
      }
    }
    users.removeAll(usersToRemove);
  }

  public List<User> getUsers() {
    return users;
  }

  public List<User> getUsersByRole(UserRole role) {
    List<User> usersByRole = new ArrayList<User>();
    for (User user : users) {
      if (user.getPossibleRoles().contains(role)) {
        usersByRole.add(user);
      }
    }
    return usersByRole;
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
 * @throws IOException
   */
  public void toJson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Object jsonObject = objectMapper.readValue(this.toString(), Object.class);
    String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    FileWriter myWriter = new FileWriter(filePath);
    myWriter.write(prettyJson);
    myWriter.close();
  }

  @Override
  public String toString() {
    return users.toString();
  }
}