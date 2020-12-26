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
                boolean usernameExists = fileService.existsAlready(newUsername, UserService.FILE_NAME);
                int lineUsername = fileService.getLine(foundUser.getUsername(), UserService.FILE_NAME);
                if (!usernameExists){
                    fileService.updateFile(newUsername, foundUser.getPassword(), foundUser.getName(),
                    foundUser.getRole(), lineUsername, UserService.FILE_NAME);
                }
				break;
			case 2:
                Scanner n = new Scanner(System.in);
				System.out.println("Type in new name: ");
                String newName;
                newName = n.nextLine();
                boolean nameExists = fileService.existsAlready(newName, UserService.FILE_NAME);
                int lineName = fileService.getLine(foundUser.getName(), UserService.FILE_NAME);
                if (!nameExists){
                    fileService.updateFile(foundUser.getUsername(), foundUser.getPassword(), newName,
                    foundUser.getRole(), lineName, UserService.FILE_NAME);
                }
				break;
			case 3:
                Scanner pass = new Scanner(System.in);
				System.out.println("Type in new password: ");
                String newPassword;
                newPassword = pass.nextLine();
                int linePass = fileService.getLine(foundUser.getUsername(), UserService.FILE_NAME);
                fileService.updateFile(foundUser.getUsername(), newPassword, foundUser.getName(),
                foundUser.getRole(), linePass, UserService.FILE_NAME);
				break;
			case 4:
				System.exit(0);
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
