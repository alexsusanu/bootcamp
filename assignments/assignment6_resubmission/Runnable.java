import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        TeslaModelsService teslaModelsService = new TeslaModelsService();
        FileService fileService = new FileService();
        for(int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            List<TeslaModels> teslaModelsList = teslaModelsService.addModelInfo(fileService.readFile(file));
            Map<String, Map<String, String>> map = teslaModelsService.getSummaryStatistics(teslaModelsList, "min");
            teslaModelsService.fullReport(teslaModelsList, file, fileService);
        }
    }
}