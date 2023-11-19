package com.command.concrete;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;
/**
 * LoginCommand
 *
 * User
 *      User attempts to log in to their account
 *
 * Valid Actors : Admin/PCC/PCM/Submitter
 * Subject : ROOT
 * Return : UUID of user if it works, null if not
 */
public class LoginCommand extends Command {

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = userName : UUID, password : UUID, currentRole : String
         * login
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
        // Every one
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
    
}
