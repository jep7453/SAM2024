package com.View;

import java.util.*;

public class View {
    Scanner sc = new Scanner(System.in);
    String originalId = "user746";
    String originalPassword = "password746";

    //Submitter Start-----------------------------------
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
            submitterHome();
        }
    }
    public void submitterHome() {
        System.out.println("1. Submit Paper\n" +
                "2. View Paper\n" +
                "3. View Report\n" +
                "4. Logout");
    }

    public void submitterViewPaper() {
        System.out.println("List of papers"); //don't know how to implement this
    }

    public void submitterViewReport() {
        System.out.println("Report");
    }

    //Submitter End-----------------------------X


    //Admin Start----------------------
    public void siteHome() {
        System.out.println("1. Set Reminder\n" +
                "2.Set up Templates");
    }

    //Admin End------------------------X


    //PCM Start----------------------
    public void pcmHome(){
        System.out.println("1. View Paper\n" +
                "2. View Review\n" +
                "3. Paper preference selection\n" +
                "4. Review Paper\n"
                "5. Logout");
    }
    public void ViewPaper(){
        System.out.println("Enter the name of the submitter: ");
        String submitterName = sc.nextLine();
        //we can use a for loop to display the submissions by the required submitter
        //maybe here the getsubmissionsbyuser will be used
        System.out.println("Enter the name of the paper: ");
        String paperName = sc.nextLine();
        //we can again use a for loop to select the paper by comapring the submissions list and the user input for paper name
        //can add a break statement when we encounter the file and display the result ie required paper
        System.out.println("The requested paper is given below\n")
    }
    public void ViewReview(){
        System.out.println("Enter the name of the submitter: ");
        String submitterName = sc.nextLine();
        //we can use a for loop to display the submissions by the required submitter
        //maybe here the getsubmissionsbyuser will be used
        System.out.println("Enter the name of the paper: ");
        String paperName = sc.nextLine();
        //we can again use a for loop to select the paper by comapring the submissions list and the user input for paper name
        //now that in this case we have the required paper we can just display the reveiew for it
        System.out.println("The review for the requested paper is given below\n")
    }
    public void reviewPaperPreference(){
        HashSet<String> paperPreferences = new HashSet<String>();
        do{
            System.out.println("Enter the name of the submitter: ");
            String submitterName = sc.nextLine();
            //we can use a for loop to display the submissions by the required submitter
            //maybe here the getsubmissionsbyuser will be used
            System.out.println("Enter the name of the paper: ");
            String paperName = sc.nextLine();
            paperPreferences.add(paperName);
            System.out.println("Do you want to add more papers? Enter 'yes' or 'no'")
            String decision = sc.nextLine();
        }
        while(decision != 'no')
    }
    public void reviewPaper(){
        // I thought this function can be done after completing the assignPaper function done by the PCC
    }
    //PCM End------------------------X


    //PCC Start----------------------
    public void pccHome(){
        System.out.println("1. View Paper\n" +
                "2. View Review\n" +
                "3. View Rating\n" +
                "4. Rate Paper\n" +
                "5. Assign Paper to PCM\n"
                "6. Logout");
    }
    //for the view paper and view review I thought using the same function as for either pcc or pcm same functionality works
    //when they want to view the paper or review
    public void pccViewRating(){
        System.out.println("Enter the name of the submitter: ");
        String submitterName = sc.nextLine();
        //we can use a for loop to display the submissions by the required submitter
        //maybe here the getsubmissionsbyuser will be used
        System.out.println("Enter the name of the paper: ");
        String paperName = sc.nextLine();
        //we can again use a for loop to select the paper by comapring the submissions list and the user input for paper name
        //now that in this case we have the required paper we can just display the rating for it
        System.out.println("The rating for the requested paper is given below\n")
    }
    public void ratePaper(){
        System.out.println("Enter the name of the submitter: ");
        String submitterName = sc.nextLine();
        //we can use a for loop to display the submissions by the required submitter
        //maybe here the getsubmissionsbyuser will be used
        System.out.println("Enter the name of the paper: ");
        String paperName = sc.nextLine();
        //we can again use a for loop to select the paper by comapring the submissions list and the user input for paper name
        System.out.println("Enter the rating that you want to give: ")
        //here I am not sure are we also accepting rating in float values,
        //if so we can just edit code to accept float values
        int paperRating = sc.nextInt();
        System.out.println("Are you sure you want to input the following rating for the below paper? (yes/no)\n");
        System.out.println(paperName + "has been rated " + paperRating + "\n");
        String choice = sc.nextLine();
        if(choice.equals("yes")){
            System.out.println("The rating of " + paperName + " has been done succesfully");
        }
        else{
            System.out.println("Enter the new rating for " + paperName + "\n");
            paperRating = sc.nextInt;
        }
    }
    public void assignPaper(){
        /* I am trying to think how we can implement the functionality where we can keep a track of alloting a paper to just 3 PCMs */
    }

    //PCC End------------------------X


    //start of main -------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id;
        String password;
        boolean flag;
        System.out.println("-----------------Login Page-----------------");
        System.out.println("Choose a role you want to sign in as :- \n" +
                "PCM : M\n" +
                "PCC : C\n" +
                "Admin :A\n" +
                "Submitter: S\n");
        String role = sc.nextLine();
        System.out.println("Enter your UserId: ");
        id = sc.nextLine();
        System.out.println("Enter your Password: ");
        password = sc.nextLine();
        if((id == originalId) && (password == originalPassword)){
            System.out.println("Sucessful Login");
            boolean = True;
        }else {
            System.out.println("Invalid Credentials");
        }
        //main switch casses
        if(boolean){
            switch(role){   
                case S:
                    submitterHome();
                    int choice = sc.nextInt();
                    case(choice){
                    case 1:
                        submitPaper();
                        break;
                    case 2:
                        submitterViewPaper();
                        break;
                    case 3:
                        submitterViewPaper();
                        break;
                    case 4:
                        //exit
                        submitterHome();
                        break;
                    default:
                        System.out.println("Invalid choice!!!");
                        break;
                    }
                case A:
                    adminHome();
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Enter the deadline: ");
                            String deadline = sc.nextLine();
                            break;
                        case 2:
                            System.out.println("Set up Template"); // don't know how to implement
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                    }
                case M:
                    pcmHome();
                    int choice = sc.nextInt();
                    case(choice){
                        case 1:
                            ViewPaper();
                            break;
                        case 2:
                            ViewReview();
                            break;
                        case 3:
                            reviewPaperPreference();
                            break;
                        case 4:
                            reviewPaper();
                            break;
                        case 5:
                            pcmHome();
                            break;
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                    }    
                case C:
                    pccHome();
                    int choice = sc.nextInt();
                    case(choice){
                        case 1:
                            ViewPaper();
                            break;
                        case 2:
                            ViewReview();
                            break;
                        case 3:
                            pccViewRating();
                            break;
                        case 4:
                            ratePaper();
                            break;
                        case 5:
                            assignPaper();
                            break;
                        case 6:
                            pccHome();
                            break;
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                    }
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }
        }

    }
}