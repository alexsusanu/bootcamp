import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SuperUser extends User{
   @Override
   public void selectOption(UserService userService, FileService fileService, User matchUser) {
      Scanner scanner = new Scanner(System.in);
      int lineNumber = fileService.getLine(matchUser.getUsername());
      int option = scanner.nextInt();
      switch (option) {
         case 0:
            List<User> users = userService.addUsers();
            Map<String, String> loginDetails = userService.askLoginDetails();
            matchUser = userService.isMatch(loginDetails.get("username"), loginDetails.get("password"), users);
            User user = userService.validateUserDetails(matchUser, users);
            checkIfSuperUser(user, users);
//            while (user.getRole().equals(userService.getSUPER_USER())){
//               System.out.println("Not allowed to login as another super user");
//               loginDetails = userService.askLoginDetails();
//               matchUser = userService.isMatch(loginDetails.get("username"), loginDetails.get("password"), users);
//               user = userService.validateUserDetails(matchUser, users);
//               userService.menuNormalUser();
//               user.selectOption(userService, fileService, matchUser);
//            }
            break;
         case 1:
            String usernameToUpdate = userService.updateUsername();
            fileService.updateFile(usernameToUpdate, matchUser.getPassword(), matchUser.getName(), matchUser.getRole(), lineNumber);
            break;
         case 2:
            String passwordToUpdate = userService.updatePassword();
            fileService.updateFile(matchUser.getUsername(), passwordToUpdate, matchUser.getName(), matchUser.getRole(), lineNumber);
            break;
         case 3:
            String nameToUpdate = userService.updateName();
            fileService.updateFile(matchUser.getUsername(), matchUser.getPassword(), nameToUpdate, matchUser.getRole(), lineNumber);
            break;
         case 4:
            System.out.println("Goodbye");
            System.exit(0);
         default:
            System.exit(0);
      }
   }
   public void checkIfSuperUser(User user, List<User> users){
      UserService userService = new UserService();
      FileService fileService = new FileService();
      while (user.getRole().equals(userService.getSUPER_USER())){
         System.out.println("Not allowed to login as another super user");
         Map<String, String> loginDetails = userService.askLoginDetails();
         User matchUser = userService.isMatch(loginDetails.get("username"), loginDetails.get("password"), users);
         user = userService.validateUserDetails(matchUser, users);
         userService.menuNormalUser();
         user.selectOption(userService, fileService, matchUser);
      }

   }
}
