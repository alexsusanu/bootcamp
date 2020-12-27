import java.util.*;
import java.io.File;

public class UserLoginApplication {
    static String username;
    static String password;
    static int loginAttempts;
	static int option;

    public static void main(String[] args){
        UserService userService = new UserService();
        FileService fileService = new FileService();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        loginAttempts = user.getLoginAttempts();
        User foundUser = userService.validateUser();
        /*
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
        */
		userService.menu(foundUser.getRole());
		while(!scanner.hasNextInt()){
			System.out.println("Invalid input.");
			scanner.nextLine();
		}
        option = scanner.nextInt();
        if (foundUser.getRole().equals(new String("normal_user"))){
            user.selectOption(foundUser, option);
        }else if (foundUser.getRole().equals(new String("super_user"))){
            SuperUser superUser = new SuperUser(foundUser.getUsername(), foundUser.getPassword(), foundUser.getName(),
            foundUser.getRole());
            superUser.selectOption(foundUser, option);
        }
    }
}
