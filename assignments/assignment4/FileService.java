import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileService {
   
    public FileService(){};
    /**
    * read from file and insert csv elements into an array
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
    public boolean existsAlready(String name, File file){
        String line;
        Scanner scanner = new Scanner(System.in);
        
        if (!file.exists() && !file.isDirectory()){
            System.out.println("File error. File doesn't exists or is a directory");
            existsAlready(name, file);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                if(line.toLowerCase().contains(name.toLowerCase())){
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
    * case insensitive, compare strings in lower cases
    * @param 1st argument old string to replace, 2nd argument: new string to replace with
    * @param 3rd argument: file of type File to check
    * @return void
    */
    public void replaceElement(String oldText, String newText, String file){
        try {
            Path path = Paths.get(file);
            Stream<String> lines = Files.lines(path);
            List<String> toReplace = lines.map(line -> line.toLowerCase().replaceAll(oldText, newText)).collect(Collectors.toList());
            Files.write(path, toReplace);
            lines.close();
        }catch (Exception e){}

    }


}
