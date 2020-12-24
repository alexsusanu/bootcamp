import java.util.*;
import java.util.stream.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

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

    /**
    * check if a string in a certain column of the csv file exists already
    * @param 1st argument string to check
    * @param 2nd argument type of element to check
    * csv file order(username, pass, name, role)
    * String t can be either "username", "name" or "role"
    * @param 3rd argument file to check in
    * @return boolean
    */
    public boolean existsAlready(String name, String t, File file){
        String line;
        int i;

        if (!file.exists() && !file.isDirectory()){
            System.out.println("File error. File doesn't exists or is a directory");
        }

        if (t.equals(new String("username"))){
            i = 0;
        }else if (t.equals(new String("name"))){
            i = 2;
        }else if (t.equals(new String("password"))){
            i = 3;
        }else {
            System.out.println("Type element undefined");
            return false;
        }
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                if(line.split(",")[i].toLowerCase().contains(name.toLowerCase())){
                    return true;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File does not exists");
            e.printStackTrace();
        }catch (IOException f){
            System.out.println("IO error");
            f.printStackTrace();
        }
        return false;
    }

    /**
    * check for a string in a file and replace all of its occurences with a new string
    * checks if file exists, print stack trace otherwise
    * @param 1st argument old string to replace 
    * @param 2nd argument: new string to replace with
    * @param 3rd argument file of type File 
    * @return no return. check if element exists before
    */
    public void replaceElement(String oldText, String newText, File file){
        if (!file.exists() && !file.isDirectory()){
            System.out.println("File error. File doesn't exists or is a directory");
        }else {
            try {
                Path path = file.toPath();
                Stream<String> lines = Files.lines(path);
                List<String> toReplace = lines.map(line -> line.replaceAll(oldText, newText)).collect(Collectors.toList());
                Files.write(path, toReplace);
                lines.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


}
