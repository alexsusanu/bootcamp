import java.util.ArrayList;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args){
        int attempts = 1;
        ArrayList<User> userArray = new ArrayList<User>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        scanner.nextLine();
        System.out.print("Enter your password: ");
        scanner.nextLine();

        if (!isMatch()){
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
            }
        }else { System.out.println("Welcome!"); }

    }
    public static boolean isMatch(){
        // if username == username.Object
        // if password == password.Object
        return false;
    }
}
