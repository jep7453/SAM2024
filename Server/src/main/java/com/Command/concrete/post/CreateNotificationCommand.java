package com.command.concrete.post;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
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


/**
 *
 * NOT IMPLEMENTING RIGHT NOW
 *
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
        return (User) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
