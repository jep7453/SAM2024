package Submitter;

public class Home {
    public static void main(String[] args) {
        int input=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("---- Submitter Home ---n");
        System.out.println("1. Submit Paper\n" +
                "2.View Paper\n" +
                "3.View Report\n" +
                "4.Logout");
        input = sc.nextInt();
        switch(input){
            case 1 :
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
                break;
            case 2:
                System.out.println("Here are the list of papers:- \n" +
                        "Paper 1\n" +
                        "Paper 2\n");
                break;
            case 3:
                System.out.println("Final Report is : "); //Todo
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Input");
        }

    }
}