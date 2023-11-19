package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

/**
 * GetAssignedReviewsRatingCommand 
 * 
 * SUBMITTER
 *      When the user needs to select from previous versions of a submission the system calls this command to get the options
 * 
 * Valid Actors : SUBMITTER
 * Subject : Submitter
 * Return : metadata previous submissions
 */
public class GetPreviousSubmissionsCommand extends Command{

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
