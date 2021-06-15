import java.io.File;
import java.util.List;

public class TeslaModelsService {
    TeslaModels teslaModels = new TeslaModels();
    DateService dateService = new DateService();
    FileService fileService = new FileService();

    public void addModelInfo(List<String> stringList) {
        String month, fullDate;
        Integer year, salesAmount;
        for (String s : stringList) {
            fullDate = s.split(",")[0]; //get date format MMM-yy
            fullDate = dateService.getDateFormat(fullDate); //format date into YY-MM
            month = s.split(",")[0].split("-")[0]; //get the month
            year = Integer.parseInt(s.split(",")[0].split("-")[1]); //get year and parse int
            year = dateService.getYearFormat(year); //format year into full number 2019 instead of 19
            salesAmount = Integer.parseInt(s.split(",")[1]); //parse int sales amount
            teslaModels.setSalesAmount(salesAmount); //set sales amount in Tesla POJO
            teslaModels.setDateService(new DateService(month, year)); // set month, year in tesla object via dateService
        }
    }
    public void fullReportByModel(File file, FileService fileService) {
        System.out.println(fileService.outputFileName(file) + " Yearly Sales Report");
        System.out.println("------------------------");
        fileService.yearOutputReport(file, dateService, fileService);
        System.out.println();
        fileService.bestWorstMonth(file, dateService, fileService, "max");
        fileService.bestWorstMonth(file, dateService, fileService, "min");
    }
}
