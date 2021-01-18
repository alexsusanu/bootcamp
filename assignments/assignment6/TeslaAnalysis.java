import javax.print.attribute.IntegerSyntax;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeslaAnalysis {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("modelS.csv");
        DateService dateService = new DateService();
        FileService fileService = new FileService();
        Integer statResult = fileService.getStatisticsInfo(file, "min");
        String dateSales = fileService.getSalesDate(file, statResult);

        List<String[]> lines = null;
        try(Stream<String> linesFile = Files.lines(file.toPath())){
            lines = linesFile.skip(1)
                             .map(line -> line.split("-|,"))
                             .collect(Collectors.toList());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }



    private static void outputReportMonth() {
        File file = new File("model3.csv");
        FileService fileService = new FileService();
        DateService dateService = new DateService();

        Integer statResult = fileService.getStatisticsInfo(file, "max");
        String salesDate = fileService.getSalesDate(file, statResult);
        String dateOutput = dateService.getDateFormat(salesDate);
        String tesla = fileService.outputFileName(file);
        System.out.println("The best month for " + tesla + " was: " + dateOutput);

        statResult = fileService.getStatisticsInfo(file, "min");
        salesDate = fileService.getSalesDate(file, statResult);
        dateOutput = dateService.getDateFormat(salesDate);
        System.out.println("The worst month for " + tesla + " was: " + dateOutput);
    }
}
