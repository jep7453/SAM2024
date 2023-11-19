package com.command.concrete.put;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;
/**
 * SetPaperPreferencesCommand 
 * 
 * PCM
 *      When the user makes a selects a submission as preferred the system calls this command for the preference to be saved
 * 
 * Valid Actors : PCM
 * Subject : User
 * Return : Success/Fail
 */
public class SetPaperPreferencesCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID
         * requestReview
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
        // PCM
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
