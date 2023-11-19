/**
 * The {@code AuthorView} class represents the view for an Author in a paper submission system.
 * It implements the {@code BaseViews} interface, providing methods for login, navigating the home screen,
 * and interacting with the submission system.
 *
 * @author Parva Shah
 * @version 1.0
 * @since 2023-11-19
 */
package Views;

import java.util.Objects;
import java.util.Scanner;

public class AuthorView implements BaseViews {

    /**
     * Scanner object for user input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Author's ID for authentication.
     */
    String id;

    /**
     * Author's password for authentication.
     */
    String password;

    /**
     * Array to store names of authors associated with the paper.
     */
    String[] name = new String[10];

    /**
     * Number of authors for the paper.
     */
    int numberOfAuthors;

    /**
     * Name of the paper being submitted.
     */
    String paperName;

    /**
     * Path to the submitted paper.
     */
    String pathToPaper;

    /**
     * {@inheritDoc}
     */
    @Override
    public void login(String id, String password) {
        if (Objects.equals(this.id, id) && Objects.equals(this.password, password)) {
            System.out.println("Login Successful as an Author!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void home() {
        System.out.println("1. Submit Paper\n" +
                "2. View Paper\n" +
                "3. View Report\n" +
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
     * Logs out of the system and returns to the site's home screen.
     */
    public void logout() {
        siteHome();
    }

    /**
     * Allows the author to submit a paper to the system.
     */
    public void submitPaper() {
        System.out.print("Enter name of Paper : ");
        paperName = sc.nextLine();
        System.out.print("Enter number followed by name of Authors: ");
        numberOfAuthors = sc.nextInt(); //maximum 10 authors in a paper
        for (int i = 0; i < numberOfAuthors; i++) {
            name[i] = sc.nextLine();
        }
        System.out.println("Enter path to paper: ");
        pathToPaper = sc.nextLine();
        System.out.println("Check if details are correct or not. (y/n)");
        System.out.println(paperName + "\n" + pathToPaper);
        String answer = sc.nextLine();
        if ((answer.equals("y") || answer.equals("Y"))) {
            System.out.println("Successfully Submitted !");
            home();
        }
    }

    /**
     * Displays the list of papers available for viewing.
     */
    public void viewPaper() {
        System.out.println("List of papers"); //don't know how to implement this
    }

    /**
     * Displays the report for the author.
     */
    public void viewReport() {
        System.out.println("Report");
    }
}
