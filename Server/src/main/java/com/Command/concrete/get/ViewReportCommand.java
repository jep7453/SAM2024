package com.command.concrete.get;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.User;
import com.model.Submission;

/**
 * ViewReportCommand
 * 
 * SUBMITTER
 *      When the user wishes to see a papers report the system calls this command to get it for them
 * 
 * Valid Actors : SUBMITTER
 * Subject : Submission
 * Return : String representation of report
 */

public class ViewReportCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        Submission subject = getSubject(subjectID);
        return subject.viewReport();
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.SUBMITTER, UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
