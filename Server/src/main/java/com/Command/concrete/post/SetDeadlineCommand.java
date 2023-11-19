package com.command.concrete.post;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;

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
public class SetDeadlineCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        User subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID, body : string, deadline : String{"dd-MM-yyyy"} 
         * setDeadling //All deadline does is tell the user that a PCC will start reviewing there submission
         */
        return null;
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
