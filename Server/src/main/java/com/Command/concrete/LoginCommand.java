package com.command.concrete;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

public class LoginCommand extends Command {

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        // User actor = getActor(userID);
        // User subject = getSubject(subjectID);
        /**
         * elements = userName : UUID, password : UUID, currentRole : String
         * login
         */
        return null;
    }

    @Override
    public User getSubject(UUID id) {
        return null;
    }

    @Override
    public boolean checkPermissions(User actor) {
        return false;
    }
    
    
}
