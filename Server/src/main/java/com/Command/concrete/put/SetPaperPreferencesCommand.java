package com.command.concrete.put;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;
/**
 * SetPaperPreferencesCommand 
 * 
 * PCM
 *      When the user makes a selects a submission as preferred the system calls this command for the preference to be saved
 * 
 * Valid Actors : PCM
 * Subject : Submission
 * Return : Success/Fail
 */
public class SetPaperPreferencesCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid permissions";
        }
        Submission subject = getSubject(subjectID);
        /**
         * elements = submissionID : UUID
         * requestReview
         */
        actor.requestReview((UUID) elements[0]);
        return "User " + actor.getName() + " requested to review paper " + ((Submission) root.getSubject((UUID) elements[0])).getTitle();
    }

    @Override
    public Submission getSubject(UUID id) {
        return (Submission) root.getSubject(id);
    }


    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
