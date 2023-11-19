package com.command.concrete.post;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.text.ParseException;
import java.util.UUID;

/**
 * AssignPaperToPCMCommand
 *
 * PCC
 *      PCC user calls this command to assign a PCM a submission to review
 *
 * Valid Actors : PCC
 * Subject : PCM
 * Return : true if it works, false if it errors
 */
public class AssignPaperToPCMCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID
         * assignPaperToPCM
         */
        subject.assignPaperToPCM((UUID) elements[0]);
        return null;
    }

    @Override
    public User getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // PCC
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
