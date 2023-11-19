package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

/**
 * GetAssignedReviewsRatingCommand 
 * 
 * PCM/PCC
 *      When the user selects a submission to rate/review the system calls this command to give them the rating/review
 * 
 * Valid Actors : PCM/PCC
 * Subject : User
 * Return : metadata assigned Reviews/Ratings
 */
public class GetAssignedReviewsRatingsCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public Object getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
