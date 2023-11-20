package com.command_tests;

import com.UserRole;
import com.command.concrete.*;
import com.command.concrete.get.*;
import com.command.concrete.post.*;
import com.command.concrete.put.*;

import com.model.Root;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.UUID;

import static org.junit.Assert.*;


public class CommandTests {

    Root root;

    UUID adminID;
    UUID pcmID;
    UUID pccID;
    UUID submitterID;

    @BeforeEach
    public void setUp() {
        root = Root.getInstance();
        String[] args = new String[0];
        root.main(args);
        adminID = UUID.fromString("321e4567-e89b-12d3-a456-426614174001");
        pccID = UUID.fromString("123e4567-e89b-12d3-a456-426614174001");

        CreateUserCommand createUserCommand = new CreateUserCommand();
        String pcm = createUserCommand.execute(adminID,null,
                "pcm_test","test_password","PCM Guy", "PCM");
        pcmID = UUID.fromString(pcm);

        String submitter = createUserCommand.execute(adminID,null,
                "submitter_test","test_password","Submitter Guy", "Submitter");

        submitterID = UUID.fromString(submitter);


    }



    @Test
    public void testViewPaperCommandExecute() {
        System.out.println("PCM ID: " + pcmID);
        System.out.println("Submitter ID: " + submitterID);
        System.out.println("PCC ID: " + pccID);
        System.out.println("Admin ID: " + adminID);

        ViewPaperCommand viewPaperCommand = new ViewPaperCommand();
        String string = viewPaperCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(string);
    }


    @Test
    public void testDeleteUserCommandExecute() {
        DeleteUserCommand deleteUserCommand = new DeleteUserCommand();
        String string = deleteUserCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
        System.out.println(string);
    }


    @Test
    public void testLoginCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        String login =loginCommand.execute(null,null,"jane_smith","password456", "SUBMITTER");
        System.out.println(login);
    }



    @Test
    public void testGetAssignedReviewsRatingsCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        String login =loginCommand.execute(null,null,"john_de","password123", "PCC");
        System.out.println(login);
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        String assign = assignPaperToPCMCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"), "5cf605b2-46e4-4879-8f8e-8e2c77e46d2a");
        System.out.println(assign);

        login =loginCommand.execute(null,null,"john_doe","password123", "PCM");
        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String reviews = getAssignedReviewsRatingsCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
        System.out.println(reviews);
    }

    @Test
    public void testGetPreviousSubmissionsCommandExecute() {
        GetPreviousSubmissionsCommand getPreviousSubmissionsCommand = new GetPreviousSubmissionsCommand();
        String previous = getPreviousSubmissionsCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(previous);
    }


    @Test
    public void testGetReviewsOnSubmissionCommandExecute() {
        GetReviewsOnSubmissionCommand getReviewsOnSubmissionCommand = new GetReviewsOnSubmissionCommand();
        String reviews = getReviewsOnSubmissionCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(reviews);
    }



    @Test
    public void testGetSubmissionsByUserCommandExecute() {
        GetSubmissionsByUserCommand getSubmissionsByUserCommand = new GetSubmissionsByUserCommand();
        String submission = getSubmissionsByUserCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
        System.out.println(submission);
    }

    @Test
    public void testGetUsersByRoleCommandExecute() {
        GetUsersByRoleCommand getUsersByRoleCommand = new GetUsersByRoleCommand();
        String roles = getUsersByRoleCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),null,
                "SUBMITTER");
        System.out.println(roles);
    }


    @Test
    public void testViewRatingCommandExecute() {
        ViewRatingCommand viewRatingCommand = new ViewRatingCommand();
        String review = viewRatingCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("65ac0c17-8b16-48e0-94c1-3aa81a3fe717"));
        System.out.println(review);
    }


    @Test
    public void testViewReportCommandExecute() {
        ViewReportCommand viewReportCommand = new ViewReportCommand();
        String report = viewReportCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(report);
    }



    @Test
    public void testViewReviewCommandExecute() {
        ViewReviewCommand viewReviewCommand = new ViewReviewCommand();
        String review = viewReviewCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("b67a5bd1-d2e1-4c61-9bf7-653a523ed019"));
        System.out.println(review);
    }



    @Test
    public void testAssignPaperToPCCCommandExecute() {
        AssignPaperToPCCCommand assignPaperToPCCCommand = new AssignPaperToPCCCommand();
        String assign = assignPaperToPCCCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("223e4567-e89b-12d3-a456-426614174002"),"3bf605b2-46e4-4879-8f8e-8e2c77e46d2a");
        System.out.println(assign);
    }


    @Test
    public void testAssignPaperToPCMCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        String login =loginCommand.execute(null,null,"john_de","password123", "PCC");
        System.out.println(login);
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        String assign = assignPaperToPCMCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"), "5cf605b2-46e4-4879-8f8e-8e2c77e46d2a");
        System.out.println(assign);

        login =loginCommand.execute(null,null,"john_doe","password123", "PCM");
        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String reviews = getAssignedReviewsRatingsCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
        System.out.println(reviews);
    }



//     @Test
//    public void testCreateNotificationCommandExecute() {
//        CreateNotificationCommand createNotificationCommand = new CreateNotificationCommand();
//        assertTrue(createNotificationCommand.execute());
//    }




     @Test
    public void testCreateUserCommandExecute() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        String user = createUserCommand.execute(UUID.fromString("321e4567-e89b-12d3-a456-426614174001"),null,
                "test","test_password","Test Guy", "SUBMITTER,PCC");
        System.out.println(user);
    }


//    @Test
//    public void testSetDeadlineCommandExecute() {
//        SetDeadlineCommand setDeadlineCommand = new SetDeadlineCommand();
//        assertTrue(setDeadlineCommand.execute());
//    }


    @Test
    public void testRatePaperCommandExecute() {
        RatePaperCommand ratePaperCommand = new RatePaperCommand();
        String rate = ratePaperCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("65ac0c17-8b16-48e0-94c1-3aa81a3fe717"), 5,"Sucks");
        System.out.println(rate);
    }
    @Test
    public void testReviewPaperCommandExecute() {
        ReviewPaperCommand reviewPaperCommand = new ReviewPaperCommand();
        String review = reviewPaperCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("4e4f8223-99a7-4edf-9430-fb4dd5b0a6c1"),4,"Sucky");
        System.out.println(review);
    }



     @Test
    public void testSetPaperPreferencesCommandExecute() {
        SetPaperPreferencesCommand setPaperPreferencesCommand = new SetPaperPreferencesCommand();
        String request = setPaperPreferencesCommand.execute(UUID.fromString("123e4567-e89b-12d3-a456-426614174001"),
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(request);

    }

    /**
    @Test
    public void testTriggerRevisionCommandExecute() {
        TriggerRevisionCommand triggerRevisionCommand = new TriggerRevisionCommand();
        assertTrue(triggerRevisionCommand.execute());
    }
    */
}