package Views;

import java.util.Objects;
import java.util.Scanner;

public class BaseView {
    Scanner sc = new Scanner(System.in);
    String id;
    String password;
    public void login(String id, String password) {
        if (Objects.equals(this.id, id) && Objects.equals(this.password, password)) {
            System.out.println("Login Successful as a Program Committee Chair!");
        }
    }
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

    public void logout() {
        siteHome();
    }
}
