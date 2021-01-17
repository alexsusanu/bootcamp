import java.io.*;
import java.nio.file.Files;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class FileService {
    public FileService(){};

    /** output report based on filename
     * @param file use filename for output
     * capitalize filename, split to get the model name/number
     * output with best month/worst month string
     */
    public String outputFileName(File file) {
        String fileWithoutExtension = file.getName().substring(0,6);
        String model = fileWithoutExtension.substring(0,5);
        String modelName = fileWithoutExtension.substring(5,6);
        String capitalize = model.substring(0,1).toUpperCase() + model.substring(1);
        String tesla = capitalize + " " + modelName;
        return tesla;
    }

    /** capitalize first letter
     * @param arg name to capitalize
     */
//    public String capitalize(String arg){
//        return arg.substring(0,1).toUpperCase() + arg.substring(1);
//    }

    /** get sales date from either min or max value as String
     * @param file to get data from, csv type
     * @param value -> either min or max value taken
     *              from getStatisticsInfo()
     * @return date for the min or max value
     */
    public String getSalesDate(File file, Integer value) {
        String line;
        String result = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while((line = reader.readLine()) != null){
                if(Integer.parseInt(line.split(",")[1]) == value){
                    result = line.split(",")[0];
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /** get statistic information
     * @param file of type csv to read data from
     * @param minMax -> minMax == "min" -> get min value from file
     * @param minMax -> minMax == "max" -> get max value from file
     * @return min or max value
     */
    public Integer getStatisticsInfo(File file, String minMax) {
        IntSummaryStatistics valueSales = null;
        Integer result = null;
        try(Stream<String> lines = Files.lines(file.toPath())){
            valueSales = lines.map(line -> line.split(","))
                    .skip(1)
                    .mapToInt(line -> Integer.parseInt(line[1]))
                    .summaryStatistics();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (minMax.equals("min")){
            result = valueSales.getMin();
        }else if (minMax.equals("max")){
            result = valueSales.getMax();
        }
        return result;
    }
}
