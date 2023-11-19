package com.command.concrete.get;

import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

/**
 * GetSubmissionByUserCommand
 * 
 * SUBMITTER
 *      When the user needs to select from their submissions the system calls this command to get the options
 * PCC/PCM
 *      When the user needs to select from the submissions that they are to review/rate the system calls this command to get the options
 * ADMIN
 *      When the user needs to select from submissions to put a deadline on the system calls this command to get the options      
 * 
 * Valid Actors : SUBMITTER/PCM/PCC/ADMIN
 * Subject : User
 * Return : metadata of the submissions tied to user
 */
public class GetSubmissionsByUserCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * getSubmissions()
         */
        return null;
    }

    @Override
    public User getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // Admin
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}