package com.View;

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
                case s:
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
                case a:
                    adminHome();
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Enter the deadline: ");
                            String deadline = sc.nextLine();
                            break;
                        case 2:
                            System.out.println("Set up Template"); // don't know how to implement

                    }

            }
        }

    }
}