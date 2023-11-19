package com.command.concrete.post;

import com.UserRole;
import com.command.Command;
import com.model.Submission;
import com.model.User;

import java.text.ParseException;
import java.util.EnumSet;
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

    /**
     * elements = submissionID : UUID
     * assignPaperToPCM
     */
    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid Permissions";
        }
        User subject = getSubject(subjectID);
        subject.assignPaperToPCM(UUID.fromString((String) elements[0]));
        return "Paper" + elements[0] + "assigned to PCM" + subjectID + "for review";
    }

    @Override
    public User getSubject(UUID id) {
        return (User) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
