package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

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
