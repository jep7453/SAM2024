package com.command.concrete.post;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;
/**
 * CreateNotificationCommand
 *
 * User
 *      PCC user calls this command to assign a PCM a submission to review
 *
 * Valid Actors : PCC
 * Subject : PCM
 * Return : true if it works, false if it errors
 */

public class CreateNotificationCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, alert : String, deadline : String{"dd-MM-yyyy"}
         * addNotification
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
