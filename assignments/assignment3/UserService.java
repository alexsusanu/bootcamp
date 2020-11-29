import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {
    static String line;
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

    public static boolean isMatch(String username, String password, ArrayList<User> userArray){
        for (int i = 0; i < userArray.size(); i++){
            if (username.toLowerCase().equals(userArray.get(i).getUsername()) && password.equals(userArray.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
    public static void getUserName(String username, String password, ArrayList<User> userArray){
        for (int i = 0; i < userArray.size(); i++){
            if (username.toLowerCase().equals(userArray.get(i).getUsername()) && password.equals(userArray.get(i).getPassword())){
                System.out.println("Welcome " + userArray.get(i).getName());
            }
        }
    }

}
