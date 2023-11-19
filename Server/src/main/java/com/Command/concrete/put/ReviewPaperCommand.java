package com.command.concrete.put;

import com.UserRole;
import com.command.Command;
import com.model.Rating;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;
/**
 * ReviewPaperCommand 
 * 
 * PCM
 *      When the user makes a review the system calls this command for the review to be saved
 * 
 * Valid Actors : PCM
 * Subject : Review
 * Return : Success/Fail
 */
public class ReviewPaperCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid permissions";
        }
        Review subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, reviewScore : int, body : String
         * reviewPaper
         */
        UUID submissionID = UUID.fromString((String) elements[0]);
        actor.reviewPaper(submissionID, (int) elements[1], (String) elements[2]);
        return "User " + actor.getName() + " reviewed paper " + submissionID;
    }

    @Override
    public Review getSubject(UUID id) {
        return (Review) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
