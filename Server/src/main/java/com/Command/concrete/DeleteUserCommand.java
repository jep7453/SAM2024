package com.command.concrete;

import com.UserRole;
import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;
/**
 * DeleteUserCommand 
 * 
 * ADMIN
 *      When the user deletes a user this command is called so that the object is deleted
 * 
 * Valid Actors : ADMIN
 * Subject : Root
 * Return : Success/Fail
 */
public class DeleteUserCommand extends Command {

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        /**
         * elements = userName : String, password : "password", possibleRoles :  <String>
         * addUser
         * elements = userID
         * deleteUser
         */
        root.deleteUser(subjectID);
        return root.getUsers().toString();
    }

    @Override
    public User getSubject(UUID id) {
        return null;
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
