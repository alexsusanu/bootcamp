import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private final File file = new File("data.txt");
    private List<String> listOfStrings = new ArrayList<>();

    /*
        read file data.txt
        add each line to a list of strings
        to use after for User object
     */
    public List<String> readFile (){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null){
                listOfStrings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        return listOfStrings;
    }
}
