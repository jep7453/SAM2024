package com.command.concrete.get;

import com.UserRole;
import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
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
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        Submission subject = getSubject(subjectID);
        return subject.viewPaper();
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.SUBMITTER, UserRole.PCM, UserRole.PCC, UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
