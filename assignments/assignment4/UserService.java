import java.util.ArrayList;
import java.io.File;

public class UserService extends User {
    public static final File FILE_NAME = new File("users.txt");
    public static final String regexEmail = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,7})$";

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
	* update user details (username, password, name)
	* uses existsAlready() and replaceElement() from FileService
	* to validate, check old/new username
	* @return updates username if successful, void otherwise
	*/
    public void updateUserDetails(String oldDetails, String newDetails){
        boolean userExists = fileService.existsAlready(newDetails, UserService.FILE_NAME);
        if (!userExists){
            fileService.replaceElement(oldDetails, newDetails, UserService.FILE_NAME);
        }
    }

	public boolean validateEmail(String email){
		return (email.matches(regexEmail));
	}

	public void menu(){
		
	}
}
