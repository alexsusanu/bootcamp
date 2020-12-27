import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;

public class User { 
    private String username;
    private String password;
    private String name;
    private String role;
    private int loginAttempts = 1;
    private final int MAX_ATTEMPTS = 5;

    public User(){}

    public User(String username, String password, String name, String role){
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUsername(){
        return username.strip();
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password.strip();
    }
    public String getName(){
        return name.strip();
    }

	public String getRole(){
		return role.strip();
	}
    public int getLoginAttempts(){
        return loginAttempts;
    }

    public int setLoginAttempts(int loginAttempts){
        return this.loginAttempts = loginAttempts;
    }

    public int getMaxAttempts(){
        return MAX_ATTEMPTS;
    }

    public void selectOption(User foundUser, int option){
        FileService fileService = new FileService();
        Scanner scanner = new Scanner(System.in);
        switch(option){
            case 1:
                Scanner newUser = new Scanner(System.in);
                System.out.println("Type in new username: ");
                String newUsername = newUser.nextLine();
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
