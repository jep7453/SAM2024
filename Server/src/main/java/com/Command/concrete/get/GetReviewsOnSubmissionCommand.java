package com.command.concrete.get;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.Submission;
import com.model.User;

/**
 * GetReviewsOnSubmissionCommand
 * 
 * PCC
 *      When the user needs to select from the reviews linked the the submission that they are rating the system calls this command to get them
 * 
 * Valid Actors : PCC
 * Subject : Submission
 * Return : metadata of reviews/rating on submission
 */
public class GetReviewsOnSubmissionCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        Submission subject = getSubject(subjectID);
        return subject.getReviews().toString();
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
