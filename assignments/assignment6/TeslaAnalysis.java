import java.io.*;

public class TeslaAnalysis {
    public static void main(String[] args) throws FileNotFoundException {
        for(int i = 0; i < args.length; i++){
            File file = new File(args[i]);
            DateService dateService = new DateService();
            FileService fileService = new FileService();
            fullReportByModel(file, dateService, fileService);
        }
    }

    private static void fullReportByModel(File file, DateService dateService, FileService fileService) {
        System.out.println(fileService.outputFileName(file) + " Yearly Sales Report");
        System.out.println("------------------------");
        fileService.yearOutputReport(file, dateService, fileService);
        System.out.println();
        fileService.bestWorstMonth(file, dateService, fileService, "max");
        fileService.bestWorstMonth(file, dateService, fileService, "min");
    }

}
