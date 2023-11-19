package com.command.concrete.get;

import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.UUID;

/**
 * VeiwPaperCommand
 * 
 * SUBMITTER/PCC/PCM
 *      When the user has selected a paper to view the system calls this command to get it
 * 
 * Valid Actors : PCC/PCM/SUBMITTER
 * Subject : Submission
 * Return : TODO string representation of paper untill we get to allowing pdf and word docs
 */

public class ViewPaperCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        Submission subject = getSubject(subjectID);
        return null;
    }

    @Override
    public Submission getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // Everyone
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
