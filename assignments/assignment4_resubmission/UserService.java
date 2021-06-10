import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private FileService fileService = new FileService();
    private List<User> userArrayList = new ArrayList<>();
    private Integer loginAttempts = 4;

    public Integer getLoginAttempts(){
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts){
        if(loginAttempts == 0){
            System.out.println("Too many attempts. You are now locked out.");
        }
        this.loginAttempts = loginAttempts;
    }

    /*
        read file data.txt
        split by comma
        create new User object based on csv position
        0 - username
        1 - password
        2 - name
     */
    public List<User> addUsers(){
        List<String> listStrings = fileService.readFile();
        for (String s : listStrings){
            userArrayList.add(new User(s.split(",")[0], s.split(",")[1], s.split(",")[2]));
        }
        return userArrayList;
    }

    public boolean isMatch(String username, String password, List<User> listOfUsers){
        for (User u : listOfUsers){
            if((u.getUsername().equalsIgnoreCase(username)) && (u.getPassword().equals(password))) {
                System.out.println("Welcome " + u.getName());
                return true;
            }
        }
        return false;
    }
}
