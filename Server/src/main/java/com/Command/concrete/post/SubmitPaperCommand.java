package com.command.concrete.post;

import java.util.EnumSet;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.Review;
import com.model.Submission;
import com.model.User;

/**
 * SubmitPaperCommand
 *
 * Submitter
 *      Submitter user calls this command to submit a paper
 *
 * Valid Actors : Submitter
 * Subject : null (if this is not a new submission chain then the head of the chain will be passed as id)
 * Return : true if it works, false if it errors
 */
public class AssignPaperToPCCCommand extends Command{

    /**
     * elements = title : String, authors : List<String>, filePath : String, submissionID
     * updatePaper()
     * 
     * elements = title : String, authors : List<String>, filePath : String
     * submitPaper()
     */
    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid Permissions";
        }
        User subject = getSubject(subjectID);
        UUID submissionID = UUID.fromString((String) elements[3]);
        if(submissionID) {
            actor.updatePaper(elements[0], elements[1], Paths.get(elements[2]), submissionID);
        } else {
            actor.submitPaper(elements[0], elements[1], Paths.get(elements[2]));
        }
        return "Paper" + elements[0] + "submitted";
    }

    @Override
    public User getSubject(UUID id) {
        return (User) root.getSubject(id);
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.SUBMITTER);
        return validRoles.contains(actor.getCurrentRole());
    }

}
