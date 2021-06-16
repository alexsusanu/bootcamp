import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Runnable {
    public static void main(String[] args){
        TeslaModelsService teslaModelsService = new TeslaModelsService();
        FileService fileService = new FileService();
        for(int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            List<TeslaModels> teslaModelsList = teslaModelsService.addModelInfo(fileService.readFile(file));
            teslaModelsService.fullReport(teslaModelsList, file, fileService);
        }
    }
}