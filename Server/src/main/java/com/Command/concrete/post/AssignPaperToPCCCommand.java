package com.command.concrete.post;

import java.util.UUID;

import com.command.Command;
import com.model.Submission;
import com.model.User;

/**
 * AssignPaperToPCCCommand
 *
 * Admin
 *      Admin user calls this command to assign a PCC a submission to rate
 *
 * Valid Actors : Admin
 * Subject : PCC
 * Return : true if it works, false if it errors
 */
public class AssignPaperToPCCCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID
         * assignPaperToPCC
         */
        subject.assignPaperToPCC((UUID) elements[0]);
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
