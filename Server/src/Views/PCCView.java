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

public class PCCView extends BaseView {

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

    public void home() {
        System.out.println("1. Assign Paper\n" +
                "2. Generate Report\n" +
                "3. Rate Paper\n" +
                "4. Logout");
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
}
