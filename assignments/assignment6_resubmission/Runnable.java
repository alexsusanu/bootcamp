import java.io.File;
import java.io.FileNotFoundException;

public class Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        TeslaModelsService teslaModelsService = new TeslaModelsService();
        FileService fileService = new FileService();
        for(int i = 0; i < args.length; i++){
            File file = new File(args[i]);
            teslaModelsService.addModelInfo(fileService.readFile(file));
            teslaModelsService.fullReportByModel(file, fileService);
        }
    }
}