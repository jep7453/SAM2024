package com.command.concrete.get;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.User;

/**
 * ViewReviewCommand
 * 
 * PCC/PCM
 *      When the user needs to see a review the system calls this command to show them
 * 
 * Valid Actors : PCC/PCM
 * Subject : Review
 * Return : string representation of Review 
 */

public class ViewReviewCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor)) {
            Review subject = getSubject(subjectID);
        } else {
            return "Actor current role not able to run command";
        }
        return null;
    }

    @Override
    public Review getSubject(UUID id) {
        return (Review) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM, UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole);
    }
    
}
