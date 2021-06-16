import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public List<String> readFile(File file) {
        String line;
        List<String> stringList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine(); //skip first line in file
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    /**
     * output report based on filename
     *
     * @param file use filename for output
     *             capitalize filename, split to get the model name/number
     *             output with best month/worst month string
     */
    public String outputFileName(File file) {
        String fileWithoutExtension = file.getName().substring(0, 6);
        String model = fileWithoutExtension.substring(0, 5);
        String modelName = fileWithoutExtension.substring(5, 6);
        String capitalize = model.substring(0, 1).toUpperCase() + model.substring(1);
        return capitalize + " " + modelName;
    }
}