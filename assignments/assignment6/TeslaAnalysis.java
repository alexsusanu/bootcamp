import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class TeslaAnalysis {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("modelS.csv");
        DateService dateService = new DateService();
        FileService fileService = new FileService();

        List<Integer> yearArray = fileService.getYears(file);
        for (Integer i : yearArray){
            System.out.println(""
                    fileService.totalPerYear(file, i));
        }

    }
}
