package com.command.concrete.put;

import com.UserRole;
import com.command.Command;
import com.model.Rating;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;

/**
 * RatePaperCommand 
 * 
 * PCC
 *      When the user makes a rating the system calls this command for the rating to be saved
 * 
 * Valid Actors : PCC
 * Subject : Rating
 * Return : Success/Fail
 */

public class RatePaperCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid permissions";
        }
        Rating subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, ratingScore : int, body : String
         * ratePaper
         */
        actor.ratePaper((UUID) elements[0], (int) elements[1], (String) elements[2]);
        return "User " + actor.getName() + " rated paper " + ((Submission) root.getSubject((UUID) elements[0])).getTitle();
    }

    @Override
    public Rating getSubject(UUID id) {
        return (Rating) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
