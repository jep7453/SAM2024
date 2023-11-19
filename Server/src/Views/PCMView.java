/**
 * The {@code PCMView} class represents the view for a Program Committee Member (PCM) in a paper submission system.
 * It implements the {@code BaseViews} interface, providing methods for login, navigating the home screen,
 * and performing actions specific to a PCM, such as selecting papers to review, viewing assigned papers, and
 * reviewing assigned papers.
 *
 * @author Parva Shah
 * @version 1.0
 * @since 2023-11-19
 */
package Views;

import java.util.Scanner;

public class PCMView implements BaseViews {

    /**
     * Scanner object for user input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * PCM's ID for authentication.
     */
    String id;

    /**
     * PCM's password for authentication.
     */
    String password;

    /**
     * {@inheritDoc}
     */
    @Override
    public void login(String id, String password) {
        // Implementation intentionally left blank for PCM login
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void home() {
        System.out.println("1. Select paper to review\n" +
                "2. View my assigned paper\n" +
                "3. Review assigned paper\n" +
                "4. Logout");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void siteHome() {
        System.out.println("Enter 1 to login");
        int answer = sc.nextInt();
        String userName = null;
        String password = null;
        if (answer == 1) {
            System.out.println("Enter username");
            userName = sc.nextLine();
            System.out.println("Enter Password");
            password = sc.nextLine();
        }
        login(userName, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void logout() {
        siteHome();
    }

    /**
     * Allows the PCM to pick a paper to review from the list of submitted papers.
     *
     * @return The ID of the selected paper for review.
     */
    public String pickPaperToReview() {
        System.out.println("List of Submitted Papers"); //todo
        System.out.print("Enter ID of paper to review : ");
        String paperID = sc.nextLine();
        System.out.println("Do you want to request another paper to review? ");
        String answer = sc.next();
        if (answer.equals("y") || answer.equals("Y")) {
            return pickPaperToReview();
        } else {
            return paperID;
        }
    }

    /**
     * Displays the list of papers assigned to the PCM.
     */
    public void viewPaperAssigned() {
        System.out.println("List of paper assigned"); // TODO: prints paper name along with ID
    }

    /**
     * Allows the PCM to review the assigned paper and provide a rating.
     *
     * @param paperID The ID of the paper to be reviewed.
     * @return The rating assigned by the PCM.
     */
    public double reviewAssignedPaper(String paperID) {
        double rating;
        System.out.print("Paper selected to Review is : " + paperID);
        System.out.print("Enter your rating for the chosen paper: ");
        rating = sc.nextDouble();
        return rating;
    }
}
