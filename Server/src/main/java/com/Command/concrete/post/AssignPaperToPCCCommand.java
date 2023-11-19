package com.command.concrete.post;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
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

    /**
     * elements = submissionID : UUID
     * assignPaperToPCC
     */
    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid Permissions";
        }
        User subject = getSubject(subjectID);
        subject.assignPaperToPCC((UUID) elements[0]);
        return "Paper" + elements[0] + "assigned to PCC" + subjectID + "for rating";
    }

    @Override
    public User getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
