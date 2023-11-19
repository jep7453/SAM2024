package com.command.concrete.get;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.Submission;
import com.model.User;

/**
 * GetAssignedReviewsRatingCommand 
 * 
 * SUBMITTER
 *      When the user needs to select from previous versions of a submission the system calls this command to get the options
 * 
 * Valid Actors : SUBMITTER
 * Subject : Submission
 * Return : metadata previous submissions
 */
public class GetPreviousSubmissionsCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        Submission subject = getSubject(subjectID);
        return subject.viewPreviousPaper();
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.SUBMITTER);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
