package com.command.concrete.put;

import com.command.Command;
import com.model.Rating;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

public class RatePaperCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        Rating subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, ratingScore : int, body : String
         * ratePaper
         */
        return null;
    }

    @Override
    public Rating getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // PCC
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
