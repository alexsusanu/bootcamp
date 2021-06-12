import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) throws IOException {
        String username, password;
        boolean match;

        UserService userService = new UserService();
        FileService fileService = new FileService();
        List<User> users = userService.addUsers();
        Integer loginAttempts = userService.getLoginAttempts();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert your username: ");
        username = scanner.nextLine();
        System.out.println("Insert your password: ");
        password = scanner.nextLine();
        match = userService.isMatch(username, password, users);

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

        if(match){
            userService.menuNormalUser();
            fileService.updateUsername(username);
        }

    }
}
