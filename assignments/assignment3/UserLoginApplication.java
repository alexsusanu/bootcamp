import java.util.Scanner;

public class UserLoginApplication {
    static String username;
    static String password;
    static int attempts = 1;

    public static void main(String[] args){
        UserService user = new UserService();
        user.readFile();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        user.isMatch(username, password, user.userArray);

        if (!user.isMatch(username, password, user.userArray)){
            while (attempts < 5){
                System.out.println("Invalid login, please try again.");
                System.out.print("Enter your email: ");
                scanner.nextLine();
                System.out.print("Enter your password: ");
                scanner.nextLine();
                attempts++;
            }
            if (attempts == 5){
                System.out.println("Too many login attempts, you are now locked out.");
                scanner.close();
            }
        }else {
            user.getUserName(username, password, user.userArray);
        }
        scanner.close();
    }

}
