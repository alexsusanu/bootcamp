import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class TeslaModelsService {
//    TeslaModels teslaModels = new TeslaModels();
    DateService dateService = new DateService();
//    FileService fileService = new FileService();

    //TODO
    public List<TeslaModels> addModelInfo(List<String> stringList) {
        List<TeslaModels> teslaModels1 = new ArrayList<>();
        String month, fullDate;
        Integer year, salesAmount;
        for (String s : stringList) {
            TeslaModels teslaModels = new TeslaModels();
            fullDate = s.split(",")[0]; //get date format MMM-yy
            fullDate = dateService.getDateFormat(fullDate); //format date into YY-MM
            month = s.split(",")[0].split("-")[0]; //get the month
            year = Integer.parseInt(s.split(",")[0].split("-")[1]); //get year and parse int
            year = dateService.getYearFormat(year); //format year into full number 2019 instead of 19
            salesAmount = Integer.parseInt(s.split(",")[1]); //parse int sales amount
            teslaModels.setSalesAmount(salesAmount); //set sales amount in Tesla POJO
            teslaModels.setDateService(new DateService(month, year)); // set month, year in tesla object via dateService
            teslaModels1.add(teslaModels);
        }
        return teslaModels1;
    }
//    public Integer totalPerYear(Integer year) {
//    }
}
