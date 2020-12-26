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
    /**
    * check if a string in a certain column of the csv file exists already
    * @param 1st argument string to check
    * @param 2nd argument type of element to check
    * csv file order(username, pass, name, role)
    * String t can be either "username", "name"
    * @param 3rd argument file to check in
    * @return line number if found, -1 otherwise
    */
    
    /*
    public void updateUserDetails(String username, String pass, String name, String role, String newDetails, String t){
        boolean userExists = fileService.existsAlready(newDetails, t, UserService.FILE_NAME);
        int line = fileService.lineNumber(username, UserService.FILE_NAME);
        if (!userExists){
            fileService.updateFile(line, UserService.FILE_NAME, newDetails, pass, name, role);
        }
    }
    */
    
	
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
