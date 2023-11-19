package com.command.concrete.get;

import com.UserRole;
import com.command.Command;
import com.model.Rating;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;

/**
 * ViewRatingCommand
 * 
 * PCC
 *      When the user needs to view a Rating the system calls this command to get it for them
 * 
 * Valid Actors : PCC
 * Subject : Rating
 * Return : String representation of a Rating
 */

public class ViewRatingCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor)) {
            Rating subject = getSubject(subjectID);
        } else {
            return "Actor current role not able to run command";
        }
        return null;
    }

    @Override
    public Rating getSubject(UUID id) {
        return (Rating) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole);
    }
    
}
