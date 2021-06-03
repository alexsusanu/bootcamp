import java.util.ArrayList;
import java.util.List;

public class UserService {
    private FileService fileService = new FileService();
    private List<User> userArrayList = new ArrayList<>();

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

    public void checkForMatch(String username, String password){

    }
}
