package com.command.concrete.get;

import com.UserRole;
import com.command.Command;
import com.model.Rating;
import com.model.Review;
import com.model.Submission;
import com.model.User;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

/**
 * GetSubmissionByUserCommand
 * 
 * SUBMITTER
 *      When the user needs to select from their submissions the system calls this command to get the options
 * PCC/PCM
 *      When the user needs to select from the submissions that they are to review/rate the system calls this command to get the options
 * ADMIN
 *      When the user needs to select from submissions to put a deadline on the system calls this command to get the options      
 * 
 * Valid Actors : SUBMITTER/PCM/PCC/ADMIN
 * Subject : User
 * Return : metadata of the submissions tied to user
 */
public class GetSubmissionsByUserCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        User subject = getSubject(subjectID);
        List<Submission> submissions = subject.getSubmissions();
        List<String> submissionIDs = new ArrayList<>();
        for (Submission submission : submissions) {
            submissionIDs.add(submission.getSubmissionID().toString());
        }
        return submissionIDs.toString();
    }

    @Override
    public User getSubject(UUID id) {
        return (User) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.SUBMITTER, UserRole.ADMIN, UserRole.PCM, UserRole.PCC);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}