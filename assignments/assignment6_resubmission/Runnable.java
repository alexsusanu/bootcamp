import java.util.List;

public class Runnable {
    public static void main(String[] args) {
        TeslaModels teslaModels = new TeslaModels();
        FileService fileService = new FileService();
        DateService dateService = new DateService();
        List<String> stringList = fileService.readFile();

        String month, fullDate;
        Integer year, salesAmount;
        for(String s : stringList){
            fullDate = s.split(",")[0]; //get date format MMM-yy
            fullDate = dateService.getDateFormat(fullDate); //format date into YY-MM
            month = s.split(",")[0].split("-")[0]; //get the month
            year = Integer.parseInt(s.split(",")[0].split("-")[1]); //get year and parse int
            year = dateService.getYearFormat(year); //format year into full number 2019 instead of 19
            salesAmount = Integer.parseInt(s.split(",")[1]); //parse int sales amount
            teslaModels.setSalesAmount(salesAmount); //set sales amount in Tesla POJO
            teslaModels.setDateService(new DateService(month, year)); // set month, year in tesla object via dateService
            System.out.println(teslaModels.getDateService().getYear());
        }
    }
}
