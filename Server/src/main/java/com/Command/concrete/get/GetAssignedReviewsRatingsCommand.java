package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;
import com.model.User;
import com.UserRole;

import java.util.*;

/**
 * GetAssignedReviewsRatingCommand 
 * 
 * PCM/PCC
 *      When the user selects a submission to rate/review the system calls this command to give them the rating/review
 * 
 * Valid Actors : PCM/PCC
 * Subject : User
 * Return : metadata assigned Reviews/Ratings
 */
public class GetAssignedReviewsRatingsCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        System.out.println(actor);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        User subject = getSubject(subjectID);
        System.out.println(subject);
        if (subject.getCurrentRole() == UserRole.PCM) {
            return subject.getAssignedReviews().toString();
        } else if (subject.getCurrentRole() == UserRole.PCC) {
            return subject.getAssignedRatings().toString();
        }
        return "Actor current role not able to run command";
    }

    @Override
    public User getSubject(UUID id) {
        return (User) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM, UserRole.PCC);
        System.out.println(actor.getCurrentRole());
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
