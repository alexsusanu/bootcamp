import java.util.*;

public class UserLoginApplication {
    static String username;
    static String password;
    static int loginAttempts;

    public static void main(String[] args){
        UserService userService = new UserService();
        FileService fileService = new FileService();
        User user = new User();

        loginAttempts = user.getLoginAttempts();
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        User foundUser = userService.matchUsernamePassword(username, password);

        if (foundUser == null){
            while (foundUser == null && loginAttempts < user.getMaxAttempts()){
                System.out.println("Invalid login, please try again.");
                System.out.print("Enter your email: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                user.setLoginAttempts(loginAttempts++);
                foundUser = userService.matchUsernamePassword(username, password);
            }
            if (loginAttempts == user.getMaxAttempts()){
                System.out.println("Too many login attempts, you are now locked out.");
                scanner.close();
            }
        } else {
            System.out.println("Welcome " + foundUser.getName()); 
        }
        
        System.out.println("Choose options: ");
        int option = scanner.nextInt();
        if (option == 1){
            System.out.println("new username: ");
            String u = scanner.next();
            userService.updateUsername(foundUser.getUsername(), u);
        }
        scanner.close();
    }
}
