import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeslaModelsService {
//    TeslaModels teslaModels = new TeslaModels();
    DateService dateService = new DateService();
//    FileService fileService = new FileService();

    //TODO
    public List<TeslaModels> addModelInfo(List<String> stringList) {
        List<TeslaModels> teslaModelsList = new ArrayList<>();
        String month, fullDate;
        int year, salesAmount;
        for (String s : stringList) {
            TeslaModels teslaModels = new TeslaModels();
            fullDate = s.split(",")[0]; //get date format MMM-yy
            fullDate = dateService.getDateFormat(fullDate); //format date into YY-MM
            month = s.split(",")[0].split("-")[0]; //get the month
            year = Integer.parseInt(s.split(",")[0].split("-")[1]); //get year and parse int
            year = dateService.getYearFormat(year); //format year into full number 2019 instead of 19
            salesAmount = Integer.parseInt(s.split(",")[1]); //parse int sales amount
            teslaModels.setSalesAmount(salesAmount); //set sales amount in Tesla POJO
            teslaModels.setDateService(new DateService(month, year, fullDate)); // set month, year in tesla object via dateService
            teslaModelsList.add(teslaModels);
        }
        return teslaModelsList;
    }
    public List<Integer> getYearList(List<TeslaModels> teslaModelsList) {
        List<Integer> yearList = teslaModelsList.stream()
                                                .map(TeslaModels::getDateService)
                                                .map(DateService::getYear)
                                                .collect(Collectors.toList());
        return yearList.stream()
                       .distinct()
                       .collect(Collectors.toList());
    }

    public Integer getTotalPerYear(Integer year, List<TeslaModels> teslaModelsList){
        return teslaModelsList.stream()
                              .filter(t -> t.getDateService().getYear().equals(year))
                              .mapToInt(TeslaModels::getSalesAmount)
                              .sum();
    }
    public void yearOutputReport(List<TeslaModels> teslaModelsList){
            for (Integer i : getYearList(teslaModelsList)){
            System.out.println(i+ " -> " + getTotalPerYear(i, teslaModelsList));
        }
    }

    public Map<String, String> getSummaryStatistics(List<TeslaModels> teslaModelsList, String minMax){
        Map<String, String> map = new HashMap<>();
        String teslaModels;

        IntSummaryStatistics summaryStatistics = teslaModelsList.stream().collect(Collectors.summarizingInt(TeslaModels::getSalesAmount));
        String max = String.valueOf(summaryStatistics.getMax());
        String min = String.valueOf(summaryStatistics.getMin());

        if(minMax.equals("max")){
            teslaModels = teslaModelsList.stream()
                    .filter(t -> t.getSalesAmount().equals(summaryStatistics.getMax()))
                    .map(TeslaModels::getDateService)
                    .map(DateService::getFullDate)
                    .collect(Collectors.joining());
            map.put(max, teslaModels);
        }else if(minMax.equals("min")){
            teslaModels = teslaModelsList.stream()
                    .filter(t -> t.getSalesAmount().equals(summaryStatistics.getMin()))
                    .map(TeslaModels::getDateService)
                    .map(DateService::getFullDate)
                    .collect(Collectors.joining());
            map.put(min, teslaModels);
        }
        return map;
    }

}
