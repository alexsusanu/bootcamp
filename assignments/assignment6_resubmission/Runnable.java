import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("model3.csv");
        TeslaModelsService teslaModelsService = new TeslaModelsService();
        FileService fileService = new FileService();
        TeslaModels teslaModels = new TeslaModels();
        List<String> stringList = fileService.readFile(file);
        List<TeslaModels> t = teslaModelsService.addModelInfo(stringList);
        for(Integer year : teslaModelsService.getYearList(t)){
            System.out.println(teslaModelsService.getTotalPerYear(year, t));
        }
//        for(int i = 0; i < args.length; i++){
//            File file = new File(args[i]);
//            teslaModelsService.addModelInfo(fileService.readFile(file));
//            teslaModelsService.fullReportByModel(file, fileService);
//        }
    }
}