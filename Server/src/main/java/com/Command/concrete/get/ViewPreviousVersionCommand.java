package com.command.concrete.get;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

/**
 * DEPRECATED
 * 
 * Valid Actors :
 * Subject :
 * Return :
 */

public class ViewPreviousVersionCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        Submission subject = getSubject(subjectID);
        return null;
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions() {
        // Submitter
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
