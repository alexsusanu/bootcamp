import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {
    int attempts = 1;
    static String line;
    static String username;
    static String password;
    static ArrayList<User> userArray = new ArrayList<User>();
    static BufferedReader file = null;

    public static ArrayList<User> readFile(){
        try {
            file = new BufferedReader(new FileReader("data.txt"));
            while ((line = file.readLine()) != null){ 
                userArray.add(new User(line.split(",")[0], line.split(",")[1], line.split(",")[2]));
            }
        } catch (FileNotFoundException e){
                System.out.println("File does not exist");
                System.exit(1);
        } catch (IOException e){
                System.out.println("I/O problem");
                System.exit(1);
        } finally {
                try {
                    file.close();
                } catch (Exception e){}
        }
        return userArray;
    }
/*
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your email: ");
    username = scanner.nextLine();
    System.out.print("Enter your password: ");
    password = scanner.nextLine();
    isMatch(username, password, userArray);

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
            scanner.close();
        }
    }else { System.out.println("Welcome!"); }
    scanner.close();
*/
    public static boolean isMatch(String username, String password, ArrayList<User> userArray){
        for (int i = 0; i < userArray.size(); i++){
            if (username.toLowerCase().equals(userArray.get(i).getUsername()) && password.equals(userArray.get(i).getPassword())){
                System.out.println("ITS A MATCH");
                return true;
            }
        }
        return false;
    }

}
