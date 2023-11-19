package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

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
