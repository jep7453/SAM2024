package com.View;

public class SubmitterUi extends View {
    Scanner sc = new Scanner(System.in);
    @Override
    public void home(){
        System.out.println("---- Submitter Home ---n");
        System.out.println("1. Submit Paper\n" +
                "2.View Paper\n" +
                "3.View Report\n" +
                "4.Logout");
    }

    public void submitPaper(){
        System.out.print("Enter name of Paper : ");
        String paperName = sc.nextLine();
        System.out.println("Enter path to paper: ");
        String pathToPaper = sc.nextLine();
        System.out.println("Check if details are correct or not. (y/n)");
        System.out.println(paperName + "\n" + pathToPaper);
        String answer = sc.nextLine();
        if ((answer.equals("y") || answer.equals("Y"))) {
            System.out.println("Successfully Submitted !");
        }else {
            System.out.println("Submission Cancelled");
        }
    }

    public void viewReport(){
        System.out.println("Here are the list of papers:- \n" +
                "Paper 1\n" +
                "Paper 2\n");
    }

    public void viewPaper(){
        System.out.println("Final Report is : ");
    }

    @Override
    public void logout(){
        home();
    }

    public static void main(String[] args) {
        home();
        int input = sc.nextInt();
        switch(input){
            case 1:
                submitPaper();
                break;
            case 2:
                viewPaper();
                break;
            case 3:
                viewReport();
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

}