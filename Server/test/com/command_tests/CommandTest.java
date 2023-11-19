package com.command_tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommandTests {

    @Test
    public void testDeleteUserCommandExecute() {
        DeleteUserCommand deleteUserCommand = new DeleteUserCommand();
        assertTrue(deleteUserCommand.execute());
    }

    @Test
    public void testLoginCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        assertTrue(loginCommand.execute());
    }

    @Test
    public void testGetAssignedReviewsRatingsCommandExecute() {
        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        assertTrue(getAssignedReviewsRatingsCommand.execute());
    }

    @Test
    public void testGetPreviousSubmissionsCommandExecute() {
        GetPreviousSubmissionsCommand getPreviousSubmissionsCommand = new GetPreviousSubmissionsCommand();
        assertTrue(getPreviousSubmissionsCommand.execute());
    }

    @Test
    public void testGetReviewsOnSubmissionCommandExecute() {
        GetReviewsOnSubmissionCommand getReviewsOnSubmissionCommand = new GetReviewsOnSubmissionCommand();
        assertTrue(getReviewsOnSubmissionCommand.execute());
    }

    @Test
    public void testGetSubmissionsByUserCommandExecute() {
        GetSubmissionsByUserCommand getSubmissionsByUserCommand = new GetSubmissionsByUserCommand();
        assertTrue(getSubmissionsByUserCommand.execute());
    }

    @Test
    public void testGetUsersByRoleCommandExecute() {
        GetUsersByRoleCommand getUsersByRoleCommand = new GetUsersByRoleCommand();
        assertTrue(getUsersByRoleCommand.execute());
    }

    @Test
    public void testViewPaperCommandExecute() {
        ViewPaperCommand viewPaperCommand = new ViewPaperCommand();
        assertTrue(viewPaperCommand.execute());
    }

    @Test
    public void testViewRatingCommandExecute() {
        ViewRatingCommand viewRatingCommand = new ViewRatingCommand();
        assertTrue(viewRatingCommand.execute());
    }

    @Test
    public void testViewReportCommandExecute() {
        ViewReportCommand viewReportCommand = new ViewReportCommand();
        assertTrue(viewReportCommand.execute());
    }

    @Test
    public void testViewReviewCommandExecute() {
        ViewReviewCommand viewReviewCommand = new ViewReviewCommand();
        assertTrue(viewReviewCommand.execute());
    }

    @Test
    public void testAssignPaperToPCCCommandExecute() {
        AssignPaperToPCCCommand assignPaperToPCCCommand = new AssignPaperToPCCCommand();
        assertTrue(assignPaperToPCCCommand.execute());
    }

    @Test
    public void testAssignPaperToPCMCommandExecute() {
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        assertTrue(assignPaperToPCMCommand.execute());
    }

    @Test
    public void testCreateNotificationCommandExecute() {
        CreateNotificationCommand createNotificationCommand = new CreateNotificationCommand();
        assertTrue(createNotificationCommand.execute());
    }

    @Test
    public void testCreateUserCommandExecute() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        assertTrue(createUserCommand.execute());
    }

    @Test
    public void testSetDeadlineCommandExecute() {
        SetDeadlineCommand setDeadlineCommand = new SetDeadlineCommand();
        assertTrue(setDeadlineCommand.execute());
    }

    @Test
    public void testRatePaperCommandExecute() {
        RatePaperCommand ratePaperCommand = new RatePaperCommand();
        assertTrue(ratePaperCommand.execute());
    }

    @Test
    public void testReviewPaperCommandExecute() {
        ReviewPaperCommand reviewPaperCommand = new ReviewPaperCommand();
        assertTrue(reviewPaperCommand.execute());
    }

    @Test
    public void testSetPaperPreferencesCommandExecute() {
        SetPaperPreferencesCommand setPaperPreferencesCommand = new SetPaperPreferencesCommand();
        assertTrue(setPaperPreferencesCommand.execute());
    }

    @Test
    public void testTriggerRevisionCommandExecute() {
        TriggerRevisionCommand triggerRevisionCommand = new TriggerRevisionCommand();
        assertTrue(triggerRevisionCommand.execute());
    }
}