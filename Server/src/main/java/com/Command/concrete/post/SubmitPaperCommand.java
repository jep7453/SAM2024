package com.command.concrete.post;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.List;
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
public class SubmitPaperCommand extends Command{

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
        if (!checkPermissions(actor)) {
            return "Invalid Permissions";
        }
        User subject = getSubject(subjectID);
        Submission submission = null;
        UUID submissionID = null;
        if (elements.length == 4) {
            submissionID = UUID.fromString((String) elements[3]);
            submission = (Submission) root.getSubject(submissionID);
        }
        //split elements 1 by commas
        String[] listOfAuthors = ((String) elements[1]).split(",");
        try {
            if (submission != null) {
                actor.updatePaper((String) elements[0], List.of(listOfAuthors), Paths.get((String) elements[2]), submissionID);
            } else {
                actor.submitPaper((String) elements[0], List.of(listOfAuthors), Paths.get((String) elements[2]));
            }
        }
         catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return "Paper " + elements[0] + " submitted";
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
