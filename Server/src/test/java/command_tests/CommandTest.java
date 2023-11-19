package command_tests;

import org.junit.Test;

import com.command.concrete.DeleteUserCommand;
import com.command.concrete.LoginCommand;
import com.command.concrete.get.GetAssignedReviewsRatingsCommand;
import com.command.concrete.get.GetPreviousSubmissionsCommand;
import com.command.concrete.get.GetReviewsOnSubmissionCommand;
import com.command.concrete.get.GetSubmissionsByUserCommand;
import com.command.concrete.get.GetUsersByRoleCommand;
import com.command.concrete.get.ViewPaperCommand;
import com.command.concrete.get.ViewRatingCommand;
import com.command.concrete.get.ViewReportCommand;
import com.command.concrete.get.ViewReviewCommand;
import com.command.concrete.post.AssignPaperToPCCCommand;
import com.command.concrete.post.AssignPaperToPCMCommand;
import com.command.concrete.post.CreateNotificationCommand;
import com.command.concrete.post.CreateUserCommand;
import com.command.concrete.post.SetDeadlineCommand;
import com.command.concrete.put.RatePaperCommand;
import com.command.concrete.put.ReviewPaperCommand;
import com.command.concrete.put.SetPaperPreferencesCommand;
import com.command.concrete.put.TriggerRevisionCommand;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void testDeleteUserCommandExecute() {
        DeleteUserCommand deleteUserCommand = new DeleteUserCommand();
        assertEquals("", deleteUserCommand.execute(null, null, null));
    }

    @Test
    public void testLoginCommandExecute() {
        LoginCommand loginCommand = new LoginCommand();
        assertEquals("", loginCommand.execute(null, null, null));
    }

    @Test
    public void testGetAssignedReviewsRatingsCommandExecute() {
        GetAssignedReviewsRatingsCommand getAssignedReviewsRatingsCommand = new GetAssignedReviewsRatingsCommand();
        assertEquals("", getAssignedReviewsRatingsCommand.execute(null, null, null));
    }

    @Test
    public void testGetPreviousSubmissionsCommandExecute() {
        GetPreviousSubmissionsCommand getPreviousSubmissionsCommand = new GetPreviousSubmissionsCommand();
        assertEquals("", getPreviousSubmissionsCommand.execute(null, null, null));
    }

    @Test
    public void testGetReviewsOnSubmissionCommandExecute() {
        GetReviewsOnSubmissionCommand getReviewsOnSubmissionCommand = new GetReviewsOnSubmissionCommand();
        assertEquals("", getReviewsOnSubmissionCommand.execute(null, null, null));
    }

    @Test
    public void testGetSubmissionsByUserCommandExecute() {
        GetSubmissionsByUserCommand getSubmissionsByUserCommand = new GetSubmissionsByUserCommand();
        assertEquals("", getSubmissionsByUserCommand.execute(null, null, null));
    }

    @Test
    public void testGetUsersByRoleCommandExecute() {
        GetUsersByRoleCommand getUsersByRoleCommand = new GetUsersByRoleCommand();
        assertEquals("", getUsersByRoleCommand.execute(null, null, null));
    }

    @Test
    public void testViewPaperCommandExecute() {
        ViewPaperCommand viewPaperCommand = new ViewPaperCommand();
        assertEquals("", viewPaperCommand.execute(null, null, null));
    }

    @Test
    public void testViewRatingCommandExecute() {
        ViewRatingCommand viewRatingCommand = new ViewRatingCommand();
        assertEquals("", viewRatingCommand.execute(null, null, null));
    }

    @Test
    public void testViewReportCommandExecute() {
        ViewReportCommand viewReportCommand = new ViewReportCommand();
        assertEquals("", viewReportCommand.execute(null, null, null));
    }

    @Test
    public void testViewReviewCommandExecute() {
        ViewReviewCommand viewReviewCommand = new ViewReviewCommand();
        assertEquals("", viewReviewCommand.execute(null, null, null));
    }

    @Test
    public void testAssignPaperToPCCCommandExecute() {
        AssignPaperToPCCCommand assignPaperToPCCCommand = new AssignPaperToPCCCommand();
        assertEquals("", assignPaperToPCCCommand.execute(null, null, null));
    }

    @Test
    public void testAssignPaperToPCMCommandExecute() {
        AssignPaperToPCMCommand assignPaperToPCMCommand = new AssignPaperToPCMCommand();
        assertEquals("", assignPaperToPCMCommand.execute(null, null, null));
    }

    @Test
    public void testCreateNotificationCommandExecute() {
        CreateNotificationCommand createNotificationCommand = new CreateNotificationCommand();
        assertEquals("", createNotificationCommand.execute(null, null, null));
    }

    @Test
    public void testCreateUserCommandExecute() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        assertEquals("", createUserCommand.execute(null, null, null));
    }

    @Test
    public void testSetDeadlineCommandExecute() {
        SetDeadlineCommand setDeadlineCommand = new SetDeadlineCommand();
        assertEquals("", setDeadlineCommand.execute(null, null, null));
    }

    @Test
    public void testRatePaperCommandExecute() {
        RatePaperCommand ratePaperCommand = new RatePaperCommand();
        assertEquals("", ratePaperCommand.execute(null, null, null));
    }

    @Test
    public void testReviewPaperCommandExecute() {
        ReviewPaperCommand reviewPaperCommand = new ReviewPaperCommand();
        assertEquals("", reviewPaperCommand.execute(null, null, null));
    }

    @Test
    public void testSetPaperPreferencesCommandExecute() {
        SetPaperPreferencesCommand setPaperPreferencesCommand = new SetPaperPreferencesCommand();
        assertEquals("", setPaperPreferencesCommand.execute(null, null, null));
    }

    @Test
    public void testTriggerRevisionCommandExecute() {
        TriggerRevisionCommand triggerRevisionCommand = new TriggerRevisionCommand();
        assertEquals("", triggerRevisionCommand.execute(null, null, null));
    }
}