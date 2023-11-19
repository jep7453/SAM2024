package com.command.concrete.put;

import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

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
        Review subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, reviewScore : int, body : String
         * reviewPaper
         */
        return null;
    }

    @Override
    public Review getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // PCM
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
