package command_tests;

import com.UserRole;
import com.command.concrete.*;
import com.command.concrete.get.*;
import com.command.concrete.post.*;
import com.command.concrete.put.*;

import com.model.Root;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.UUID;

import static org.junit.Assert.*;


public class CommandTest {


    static UUID adminID;
    static UUID pcmID;
    static UUID pccID;
    static UUID submitterID;

    @BeforeAll
    public static void setUp() {

        Root root = Root.getInstance();
        adminID = UUID.fromString("321e4567-e89b-12d3-a456-426614174001");
        pccID = UUID.fromString("123e4567-e89b-12d3-a456-426614174001");

        CreateUserCommand createUserCommand = new CreateUserCommand();
        String pcm = createUserCommand.execute(adminID,null,
                "pcm_test","test_password","PCM Guy", "PCM");
        pcmID = UUID.fromString(pcm);

        String submitter = createUserCommand.execute(adminID,null,
                "submitter_test","test_password","Submitter Guy", "SUBMITTER");

        submitterID = UUID.fromString(submitter);


    }

    public String prettyJson(String json) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Object jsonObject = objectMapper.readValue(json, Object.class);
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        return prettyJson;
    }

    @Test
    public void testViewPaperCommandExecute() {

        ViewPaperCommand viewPaperCommand = new ViewPaperCommand();
        String string = viewPaperCommand.execute(pccID,
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(string);
        Assertions.assertNotNull(string);
    }





    @Test
    public void testLoginCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        String login =loginCommand.execute(null,null,"jane_smith","password456", "SUBMITTER");
        System.out.println(login);
        Assert.assertEquals("223e4567-e89b-12d3-a456-426614174002",login);
    }



    @Test
    public void testGetAssignedReviewsCommandExecute() {
        String paperID = "5cf605b2-46e4-4879-8f8e-8e2c77e46d2a";
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        String assign = assignPaperToPCMCommand.execute(pccID,pcmID, paperID);
        System.out.println(assign);

        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"pcm_test","test_password", "PCM");
        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String reviews = getAssignedReviewsRatingsCommand.execute(pcmID,pcmID);
        System.out.println(reviews);
        Assertions.assertTrue(reviews.contains(paperID));
    }

    @Test
    public void testGetAssignedRatingsCommandExecute() {
        String paperID = "5cf605b2-46e4-4879-8f8e-8e2c77e46d2a";
        AssignPaperToPCCCommand assignPaperToPCCCommand = new AssignPaperToPCCCommand();
        String assign = assignPaperToPCCCommand.execute(adminID,pccID, paperID);
        System.out.println(assign);

        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String ratings = getAssignedReviewsRatingsCommand.execute(pccID,pccID);
        System.out.println(ratings);
        Assertions.assertTrue(ratings.contains(paperID));
    }

    @Test
    public void testGetPreviousSubmissionsCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"john_doe","password123", "SUBMITTER");

        GetPreviousSubmissionsCommand getPreviousSubmissionsCommand = new GetPreviousSubmissionsCommand();
        String previous = getPreviousSubmissionsCommand.execute(pccID,
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(previous);
        Assertions.assertTrue(previous.contains("2bf605b2-46e4-4879-8f8e-8e2c77e46d2b"));
    }


    @Test
    public void testGetReviewsOnSubmissionCommandExecute() {
        GetReviewsOnSubmissionCommand getReviewsOnSubmissionCommand = new GetReviewsOnSubmissionCommand();
        String reviews = getReviewsOnSubmissionCommand.execute(pccID,
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(reviews);
        Assertions.assertTrue(reviews.contains("4e4f8223-99a7-4edf-9430-fb4dd5b0a6c1")
                &&reviews.contains("85c354e2-4cc8-49f9-a8a2-b0f17f37a32a"));
    }



    @Test
    public void testGetSubmissionsByUserCommandExecute() {
        GetSubmissionsByUserCommand getSubmissionsByUserCommand = new GetSubmissionsByUserCommand();
        String submission = getSubmissionsByUserCommand.execute(pccID,
                UUID.fromString("123e4567-e89b-12d3-a456-426614174001"));
        System.out.println(submission);
        Assertions.assertTrue(submission.contains("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
    }

    @Test
    public void testGetUsersByRoleCommandExecute() {
        GetUsersByRoleCommand getUsersByRoleCommand = new GetUsersByRoleCommand();
        String roles = getUsersByRoleCommand.execute(adminID,null,
                "SUBMITTER");
        System.out.println(roles);
        Assertions.assertTrue(roles.contains(submitterID.toString())
                &&roles.contains("223e4567-e89b-12d3-a456-426614174002")&&roles.contains(pccID.toString()));
    }


    @Test
    public void testViewRatingCommandExecute() {
        ViewRatingCommand viewRatingCommand = new ViewRatingCommand();
        String review = viewRatingCommand.execute(pccID,
                UUID.fromString("65ac0c17-8b16-48e0-94c1-3aa81a3fe717"));
        System.out.println(review);
        Assertions.assertTrue(review.contains("Great work!")&&review.contains("Score: 4"));
    }


    @Test
    public void testViewReportCommandExecute() {
        ViewReportCommand viewReportCommand = new ViewReportCommand();
        String report = viewReportCommand.execute(pccID,
                UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a"));
        System.out.println(report);
        Assertions.assertTrue(report.contains("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a")
                &&report.contains("Body: Constructive criticism")
                &&report.contains("Body: Great work!"));
    }



    @Test
    public void testViewReviewCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"john_doe","password123", "PCC");

        ViewReviewCommand viewReviewCommand = new ViewReviewCommand();
        String review = viewReviewCommand.execute(pccID,
                UUID.fromString("b67a5bd1-d2e1-4c61-9bf7-653a523ed019"));
        System.out.println(review);
        Assertions.assertTrue(review.contains("Previous review")
                &&review.contains("Score: 3"));
    }



    @Test
    public void testAssignPaperToPCCCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"john_doe","password123", "PCC");

        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String emptyRating = getAssignedReviewsRatingsCommand.execute(pccID,pccID);
        System.out.println(emptyRating);

        String paperID = "2bf605b2-46e4-4879-8f8e-8e2c77e46d2b";
        AssignPaperToPCCCommand assignPaperToPCCCommand = new AssignPaperToPCCCommand();
        String assign = assignPaperToPCCCommand.execute(adminID,
                pccID,paperID);
        System.out.println(assign);

        String rating = getAssignedReviewsRatingsCommand.execute(pccID,pccID);
        System.out.println(rating);
        Assertions.assertTrue(rating.contains(paperID)&&!emptyRating.contains(paperID));
    }


    @Test
    public void testAssignPaperToPCMCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"pcm_test","test_password", "PCM");

        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        String emptyReviews = getAssignedReviewsRatingsCommand.execute(pcmID,pcmID);
        System.out.println(emptyReviews);

        String paperID = "2bf605b2-46e4-4879-8f8e-8e2c77e46d2b";
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        String assign = assignPaperToPCMCommand.execute(pccID,pcmID, paperID);
        System.out.println(assign);

        String reviews = getAssignedReviewsRatingsCommand.execute(pcmID,pcmID);
        System.out.println(reviews);
        Assertions.assertTrue(reviews.contains(paperID)&&!emptyReviews.contains(paperID));
    }



//     @Test
//    public void testCreateNotificationCommandExecute() {
//        CreateNotificationCommand createNotificationCommand = new CreateNotificationCommand();
//        assertTrue(createNotificationCommand.execute());
//    }




    @Test
    public void testCreateUserCommandExecute() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        String user = createUserCommand.execute(adminID,null,
                "test","test_password","Test Guy", "SUBMITTER,PCC");
        System.out.println(user);

        GetUsersByRoleCommand getUsersByRoleCommand = new GetUsersByRoleCommand();
        String roles = getUsersByRoleCommand.execute(adminID,null,
                "SUBMITTER");
        System.out.println(roles);

        Assertions.assertTrue(roles.contains(user));

    }


//    @Test
//    public void testSetDeadlineCommandExecute() {
//        SetDeadlineCommand setDeadlineCommand = new SetDeadlineCommand();
//        assertTrue(setDeadlineCommand.execute());
//    }


    @Test
    public void testRatePaperCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"john_doe","password123", "PCC");

        UUID ratingID = UUID.fromString("39bd474f-c98d-43a1-bd08-5acfdac853f9");
        ViewRatingCommand viewRatingCommand = new ViewRatingCommand();
        String emptyRating = viewRatingCommand.execute(pccID,ratingID);
        System.out.println(emptyRating);

        RatePaperCommand ratePaperCommand = new RatePaperCommand();
        String rate = ratePaperCommand.execute(pccID, ratingID, 5,"Sucks");
        System.out.println(rate);

        String rating = viewRatingCommand.execute(pccID,ratingID);
        System.out.println(rating);
        Assertions.assertTrue(rating.contains("Score: 5")&&rating.contains("Body: Sucks")
                &&!emptyRating.contains("Score: 5")&&!emptyRating.contains("Body: Sucks"));
    }
    @Test
    public void testReviewPaperCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"john_doe","password123", "PCC");

        UUID reviewID = UUID.fromString("4e4f8223-99a7-4edf-9430-fb4dd5b0a6c1");
        ViewReviewCommand viewReviewCommand = new ViewReviewCommand();
        String emptyReview = viewReviewCommand.execute(pccID,reviewID);
        System.out.println(emptyReview);

        loginCommand.execute(null,null,"pcm_test","test_password", "PCM");

        ReviewPaperCommand reviewPaperCommand = new ReviewPaperCommand();
        String reviewed = reviewPaperCommand.execute(pcmID, reviewID, 2,"Stinks");
        System.out.println(reviewed);

        String review = viewReviewCommand.execute(pccID,reviewID);
        System.out.println(review);
        Assertions.assertTrue(review.contains("Score: 2")&&review.contains("Body: Stinks")
                &&!emptyReview.contains("Score: 2")&&!emptyReview.contains("Body: Stinks"));
    }



    @Test
    public void testSetPaperPreferencesCommandExecute() {
        UUID paperID = UUID.fromString("3bf605b2-46e4-4879-8f8e-8e2c77e46d2a");
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"pcm_test","test_password", "PCM");

        SetPaperPreferencesCommand setPaperPreferencesCommand = new SetPaperPreferencesCommand();
        String request = setPaperPreferencesCommand.execute(pcmID, paperID);
        System.out.println(request);

        GetPaperPreferencesCommand getPaperPreferencesCommand = new GetPaperPreferencesCommand();
        String preferences = getPaperPreferencesCommand.execute(pcmID,pcmID);
        System.out.println(preferences);
        Assertions.assertTrue(preferences.contains(paperID.toString()));

    }

    @Test
    public void testSubmitPaperCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.execute(null,null,"submitter_test","test_password", "SUBMITTER");

        SubmitPaperCommand submitPaperCommand = new SubmitPaperCommand();
        String submission = submitPaperCommand.execute(submitterID,null,
                "Test Paper","author1,author2","/path/to/file");
        System.out.println(submission);

        GetSubmissionsByUserCommand getSubmissionsByUserCommand = new GetSubmissionsByUserCommand();
        String submissions = getSubmissionsByUserCommand.execute(pccID,submitterID);
        System.out.println(submissions);
        Assertions.assertFalse(submissions.equals("[]"));
    }

    /**
     @Test
     public void testTriggerRevisionCommandExecute() {
     TriggerRevisionCommand triggerRevisionCommand = new TriggerRevisionCommand();
     assertTrue(triggerRevisionCommand.execute());
     }
     */

    @Test
    public void testDeleteUserCommandExecute() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        String user = createUserCommand.execute(adminID,null,
                "delete","test_password","Delete Guy", "SUBMITTER,PCC");
        UUID deleteID = UUID.fromString(user);


        DeleteUserCommand deleteUserCommand = new DeleteUserCommand();
        String string = deleteUserCommand.execute( adminID,deleteID);
        System.out.println(string);
        Assertions.assertFalse(string.contains(deleteID.toString()));
    }
}