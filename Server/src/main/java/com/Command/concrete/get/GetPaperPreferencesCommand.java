package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;
import com.model.User;
import com.UserRole;

import java.util.*;

/**
  * GetPaperPreferencesCommand
  *
  * PCC/PCM
  *      When the user needs to see a review the system calls this command to show them
  *
  * Valid Actors : PCC/PCM
  * Subject : PCM
  * Return : UUID of paper preferences
  */
public class GetPaperPreferencesCommand extends Command{

  @Override
  public String execute(UUID userID, UUID subjectID, Object... elements) {
    User actor = getActor(userID);
    if (!checkPermissions(actor)) {
      return "Actor current role not able to run command";
    }
    User subject = getSubject(subjectID);
    return subject.getRequestedSubmissions().toString();
  }

  @Override
  public User getSubject(UUID id) {
    return (User) root.getSubject(id);
  }

  @Override
  public boolean checkPermissions(User actor) {
    EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM, UserRole.PCC);
    return validRoles.contains(actor.getCurrentRole());
  }

}
