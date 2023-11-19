/**
 * The {@code PCCView} class represents the view for a Program Committee Chair (PCC) in a paper submission system.
 * It implements the {@code BaseViews} interface, providing methods for login, navigating the home screen,
 * and performing actions specific to a PCC, such as assigning papers, generating reports, and rating papers.
 *
 * @author Parva Shah
 * @version 1.0
 * @since 2023-11-19
 */
package Views;

import java.util.Objects;
import java.util.Scanner;

public class PCCView implements BaseViews {

    /**
     * Scanner object for user input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * PCC's ID for authentication.
     */
    String id;

    /**
     * PCC's password for authentication.
     */
    String password;

    /**
     * {@inheritDoc}
     */
    @Override
    public void login(String id, String password) {
        if (Objects.equals(this.id, id) && Objects.equals(this.password, password)) {
            System.out.println("Login Successful as a Program Committee Chair!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void home() {
        System.out.println("1. Assign Paper\n" +
                "2. Generate Report\n" +
                "3. Rate Paper\n" +
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
     * Assigns the paper with the given ID to Program Committee Members (PCMs) for review.
     *
     * @param paperID The ID of the paper to be assigned.
     */
    public void assignToPCM(String paperID) {
        System.out.println("Prints PCM's list who've chosen to review the paper");
//        PCM.paperToReview = paperID;
    }

    /**
     * Generates a report for the paper with the given ID.
     *
     * @param paperID The ID of the paper for which the report is generated.
     */
    public void generateReport(String paperID) {
        System.out.println("Report for " + paperID + " is : ");
//        getReport(paperID);
    }

    /**
     * Retrieves the rating assigned by the PCC for the paper with the given ID.
     *
     * @param paperID The ID of the paper for which the rating is obtained.
     * @return The rating assigned by the PCC.
     */
    public double ratingByPCC(String paperID) {
        double rating = 0;
        return rating;
    }

    /**
     * Rates the paper with the given ID based on the PCC's evaluation.
     *
     * @param paperId The ID of the paper to be rated.
     * @return The rating assigned by the PCC.
     */
    public double ratePaper(String paperId) {
        double paperRating;
        paperRating = ratingByPCC(paperId);
        return paperRating;
    }

    /**
     * Logs out of the system and returns to the site's home screen.
     */
    public void logout() {
        siteHome();
    }
}
