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
