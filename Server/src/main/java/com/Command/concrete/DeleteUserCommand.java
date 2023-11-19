package com.command.concrete;

import com.command.Command;
import com.model.Submission;
import com.model.User;

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
        /**
         * elements = userName : String, password : "password", possibleRoles :  <String>
         * addUser
         * elements = userID
         * deleteUser
         */
        return null;
    }

    @Override
    public User getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // Admin
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
