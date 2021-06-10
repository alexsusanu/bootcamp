import java.util.List;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        String username, password;
        UserService userService = new UserService();
        List<User> users = userService.addUsers();
        Integer loginAttempts = userService.getLoginAttempts();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert your username: ");
        username = scanner.nextLine();
        System.out.println("Insert your password: ");
        password = scanner.nextLine();
        boolean match = userService.isMatch(username, password, users);

        while(loginAttempts > 0 && !match){
            System.out.println("Invalid login. Try again.");
            System.out.println("Insert your username: ");
            username = scanner.nextLine();
            System.out.println("Insert your password: ");
            password = scanner.nextLine();

            match = userService.isMatch(username, password, users);
            userService.setLoginAttempts(loginAttempts - 1);
            loginAttempts = userService.getLoginAttempts();
        }
    }
}
