import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("model3.csv");
        TeslaModelsService teslaModelsService = new TeslaModelsService();
        FileService fileService = new FileService();
//        for(int i = 0; i < args.length; i++){
//            File file = new File(args[i]);
            List<TeslaModels> teslaModelsList = teslaModelsService.addModelInfo(fileService.readFile(file));
//        System.out.println(teslaModelsService.getSummaryStatistics(teslaModelsList, "min"));
        Map<String, String> map = teslaModelsService.getSummaryStatistics(teslaModelsList, "min");
        System.out.println(map.get(1));
//        System.out.println(teslaModelsService.getSummaryStatistics(teslaModelsList, "max"));
//            teslaModelsService.yearOutputReport(teslaModelsList);
//            System.out.println(fileService.outputFileName(file) + " Yearly Sales Report");
//            System.out.println("------------------------");
//            teslaModelsService.yearOutputReport(teslaModelsList);
//            System.out.println();
//        }
    }
}