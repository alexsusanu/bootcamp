import java.util.List;
import java.util.Map;

public class UserLoginApplication {
    public static void main(String[] args){
        User user = new User();
        UserService userService = new UserService();
        FileService fileService = new FileService();
        List<User> users = userService.addUsers();

        Map<String, String> loginDetails = userService.askLoginDetails();
        User matchUser = userService.isMatch(loginDetails.get("username"), loginDetails.get("password"), users);

        while (userService.getLoginAttempts() > 0 && matchUser == null) {
            matchUser = userService.validateUserDetails(matchUser, users);
        }

        if(matchUser != null && matchUser.getRole().equals(userService.getSUPER_USER())){
            userService.menuSuperUser();
            SuperUser superUser = new SuperUser();
            superUser.selectOption(userService, fileService, matchUser);
        }else if (matchUser != null && matchUser.getRole().equals(userService.getNORMAL_USER())){
            userService.menuNormalUser();
            user.selectOption(userService, fileService, matchUser);
        }

    }

}
