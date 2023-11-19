package Views;

import java.util.Objects;
import java.util.Scanner;

public class AdminView implements BaseViews {
    Scanner sc = new Scanner(System.in);
    String id;
    String password;

    @Override
    public void login(String id, String password) {
        if (Objects.equals(this.id, id) && Objects.equals(this.password, password)){
            System.out.println("Login Successful as an Author!");
        }
    }

    @Override
    public void home() {

    }

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
    @Override
    public void logout() {
        siteHome();
    }

    //TODO
    //Don't know how the template setting works!
}
