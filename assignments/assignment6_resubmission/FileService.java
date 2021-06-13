import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
   File FILE = new File("model3.csv");
   public List<String> readFile(){
      String line;
      List<String> stringList = new ArrayList<>();
      BufferedReader bufferedReader = null;
      try{
         bufferedReader = new BufferedReader(new FileReader(FILE));
         bufferedReader.readLine(); //skip first line in file
         while((line = bufferedReader.readLine()) != null){
            stringList.add(line);
         }
      }catch (IOException e){
         e.printStackTrace();
      }finally {
         try{
            if(bufferedReader != null)
               bufferedReader.close();
         }catch (IOException e){
            e.printStackTrace();
         }
      }
      return stringList;
   }
}