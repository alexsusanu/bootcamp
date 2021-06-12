import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    private final File FILE = new File("users.txt");
    private List<String> listOfStrings = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    /*
        read file data.txt
        add each line to a list of strings
        to use after for User object
     */
    public List<String> readFile (){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
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

    public void updateUsername(String username){
        File tempFile = new File("temp.txt");
        String line;
        System.out.println("Type in your new username: ");
        String newUsername = scanner.nextLine();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(username)) {
                    bufferedWriter.write(newUsername + System.lineSeparator());
                }
            }
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
