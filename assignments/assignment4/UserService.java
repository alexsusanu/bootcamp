import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UserService {
    public static final File FILE_NAME = new File("users.txt");
    public static final String regexEmail = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,7})$";
	private static final String superRole = "super_user";
	private static final String normalRole = "normal_user";

    FileService fileService = new FileService();

    public User validateUser(){
        User user = new User();
        UserService userService = new UserService();

        int loginAttempts = user.getLoginAttempts();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
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
        return foundUser;
    }


    /**
    * match username and password
    * @param String username and password
    * @return said username as User object
    * or null if not found
    */
    public User matchUsernamePassword(String username, String password){
        ArrayList<User> userArray = fileService.readFile();
        for (int i = 0; i < userArray.size(); i++){
            if (username.toLowerCase().equals(userArray.get(i).getUsername()) && password.equals(userArray.get(i).getPassword())){
                return userArray.get(i);
            }
        }
        return null;
    }
    
	
	public boolean validateEmail(String email){
		return email.matches(regexEmail);
	}

    public void menu(String role){
        if (role.equals(superRole)){
			System.out.println("Please choose from the following options");
            System.out.println("(0) Log in as another user");
            welcome();
        }else if (role.equals(normalRole)){
			System.out.println("Please choose from the following options");
            welcome();
        }
        
    }
   
    public void welcome(){
        System.out.println("(1) Update username");
        System.out.println("(2) Update name");
        System.out.println("(3) Update password");
        System.out.println("(4) Exit");
   }

	
}
