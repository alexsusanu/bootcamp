import java.util.*;

public class UserLoginApplication {
    static String username;
    static String password;
    static int loginAttempts;
	static int option;

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
       	
		userService.menu(foundUser.getRole());
		while(!scanner.hasNextInt()){
			System.out.println("Invalid input.");
			scanner.nextLine();
		}
		option = scanner.nextInt();
		switch(option){
			case 1:
				System.out.println("Type in new username: ");
				String newUsername = scanner.next();
                boolean userExists = fileService.existsAlready(newUsername, UserService.FILE_NAME);
                System.out.println(userExists);
                int line = fileService.getLine(foundUser.getUsername(), UserService.FILE_NAME);
                if (!userExists){
                    fileService.updateFile(newUsername, foundUser.getPassword(), foundUser.getName(),
                    foundUser.getRole(), line, UserService.FILE_NAME);
                }
				break;
			case 2:
				System.out.println("Type in new name: ");
				String newName = scanner.next();
				break;
			case 3:
				//update pass
				break;
			case 4:
				//exit
				break;
			default:
				try {
					System.out.println("Invalid input. Select again.");
					option = scanner.nextInt();
					while(option > 5 && -1 < option){
						System.out.println("Invalid option selected.");
						option = scanner.nextInt();
					}
				}catch(InputMismatchException e){
					while(!scanner.hasNextInt()){
						System.out.println("Invalid input. Digits only.");
						option = scanner.nextInt();
					}
				}
				break;
		}
		
    }
}
