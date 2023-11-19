package com.command.concrete.put;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.EnumSet;
import java.util.UUID;
/**
 * TriggerRevisionCommand 
 * 
 * PCC
 *      When the user sets a group of reviews as needing revision the system calls this command to save the decision
 * 
 * Valid Actors : PCC
 * Subject : Submission
 * Return : Success/Fail
 */
public class TriggerRevisionCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        Submission subject = getSubject(subjectID);
        /**
         * elements = body : String
         * triggerRevision
         */
        return null;
    }

    @Override
    public Submission getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
