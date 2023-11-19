package com.command.concrete.put;

import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

public class TriggerRevisionCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        Submission subject = getSubject(subjectID);
        /**
         * elements = body : String
         * triggerRevision
         */
        return null;
    }

    @Override
    public Submission getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // PCC
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
