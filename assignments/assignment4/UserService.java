import java.util.ArrayList;
import java.io.File;

public class UserService extends User {
    public static final File FILE_NAME = new File("users.txt");

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

    public void updateUsername(String oldUsername, String newUsername){
        boolean userExists = fileService.existsAlready(newUsername, UserService.FILE_NAME);
        System.out.println(userExists);
        if (!userExists){
            fileService.replaceElement(oldUsername, newUsername, UserService.FILE_NAME);
        }
    }
}
