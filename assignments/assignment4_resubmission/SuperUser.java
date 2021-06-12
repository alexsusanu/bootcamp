import java.util.List;
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
            String[] loginDetails = userService.askLoginDetails();
            matchUser = userService.isMatch(loginDetails[0], loginDetails[1], users);
            userService.validateUserDetails(matchUser, users);
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
}
