import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserLoginApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> user = userService.addUsers();
    }
}
