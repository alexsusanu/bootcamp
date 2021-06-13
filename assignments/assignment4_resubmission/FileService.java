import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private final File FILE = new File("users.txt");
    private List<String> listOfStrings = new ArrayList<>();

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

    public int getLine(String username){
        String line;
        int lineNumber = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
            while ((line = bufferedReader.readLine()) != null) {
                ++lineNumber;
                if (line.contains(username)) {
                    return lineNumber;
                }
            }
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    public void updateFile(String username, String password, String name, String role, int i){
        File tempFile = new File("temp.txt");
        String line;
        int lineNumber = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while ((line = bufferedReader.readLine()) != null) {
                ++lineNumber;
                if (lineNumber == i) {
                    bufferedWriter.write(username + ", " + password + ", " + name + ", " + role + System.lineSeparator());
                }else {
                    bufferedWriter.write(line + System.lineSeparator());
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            tempFile.renameTo(FILE);
        } catch (IOException e){
            e.printStackTrace();
        }
        orderFile();
    }

    public void orderFile(){
        File tempFile = new File("temp.txt");
        String line;
        ArrayList<String> superUserArray = new ArrayList<>();
        ArrayList<String> normalUserArray = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(",")[3].strip().equals("super_user")) {
                    superUserArray.add(line);
                } else {
                    normalUserArray.add(line);
                }
            }
            List<String> s = superUserArray.stream().sorted().collect(Collectors.toList());
            List<String> n = normalUserArray.stream().sorted().collect(Collectors.toList());
            for(String x : s){
                bufferedWriter.append(x + System.lineSeparator());
            }
            for(String x : n){
                bufferedWriter.append(x + System.lineSeparator());
            }
            bufferedWriter.close();
            bufferedReader.close();
            tempFile.renameTo(FILE);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
