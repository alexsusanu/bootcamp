import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileService {
   
    public FileService(){};
    /**
    * read from csv file and insert csv elements into an array
    * the array will act as User constructor params
    * return an array of User objects
    */
    public ArrayList<User> readFile(){
        String line;
        ArrayList<User> userArray = new ArrayList<User>();
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(UserService.FILE_NAME));
            while ((line = file.readLine()) != null){ 
                userArray.add(new User(line.split(",")[0], line.split(",")[1], line.split(",")[2], line.split(",")[3]));
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
                } catch (Exception e){
                    e.printStackTrace();
                }
        }
        return userArray;
    }

    public boolean existsAlready(String s, File file){
    String line;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                if (line.contains(s)){
                    return true;
                }
            }
        }catch (IOException e){}
        return false;
    }   
    
    public int getLine(String s, File file){
    String line;
    int lineNumber = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                ++lineNumber;
                if (line.contains(s)){
                    return lineNumber; 
                }
            }
        }catch (IOException e){}
        return -1;
    }

    public void updateFile(String username, String pass, String name, String role, int i, File oldFile){
        File newFile = new File("test.txt");
        int lineNumber = 0;
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(oldFile));        
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            while((line = reader.readLine()) != null){
                lineNumber += 1;
                if (lineNumber == i){
                    writer.write(username + ", " + pass + ", " + name + ", " + role + System.lineSeparator());
                }else {
                    writer.write(line + System.lineSeparator());
                }
            }
            writer.close();
            reader.close();
            newFile.renameTo(oldFile);
        
        }catch (IOException e){}


    }

}
