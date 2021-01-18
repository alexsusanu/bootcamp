import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
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
        return capitalize + " " + modelName;
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

    /** get years from file
     * @param file csv
     * @return years as array
     */
    public List<Integer> getYears(File file) {
        List<Integer> yearsArray = new ArrayList<>();
        try(Stream<String> lines = Files.lines(file.toPath())){
            lines.skip(1)
                    .map(line -> line.split("-|,")[1])
                    .distinct()
                    .mapToInt(l -> Integer.parseInt(l))
                    .forEachOrdered(yearsArray::add);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return yearsArray;
    }

    /** get total sales per one year
     * @param file csv file
     * @param year as last two digits 2018 -> 18
     * if year doesnt exists total return is 0 (zero)
     * @return total sales for the year specified
     */
    public Integer totalPerYear(File file, Integer year) {
        List<Integer> values =  new ArrayList<>();
        Integer resultValues = null;
        try(Stream<String> lines = Files.lines(file.toPath())){
            lines.skip(1) // skip first line of csv file (date, sales strings)
                    .forEach(
                            line -> {
                                if(Integer.parseInt(line.split("-|,")[1]) == year){
                                    values.add(Integer.parseInt(line.split("-|,")[2]));
                                }
                            }
                    );
            resultValues = values.stream().reduce(0, Integer::sum);
        }catch(IOException e){
            e.printStackTrace();
        }
        return resultValues;
    }

    /** get output best or worst month for model###
     * @param file csv file
     * @param dateService output date in format yyyy-MM
     * @param fileService fileService class use of methods
     * @param minMax "min" -> returns worst month
     *               "max" -> returns best month
     */
    public void bestWorstMonth(File file, DateService dateService, FileService fileService, String minMax) {
        Integer statResult = null; // return min or max value
        String salesDate; // get the date for the min or max value
        String dateOutput; // output date in format yyyy-MM
        String tesla; // return filename as string capitalized

        if(minMax.equals("max")){
            statResult = fileService.getStatisticsInfo(file, "max");
            salesDate = fileService.getSalesDate(file, statResult);
            dateOutput = dateService.getDateFormat(salesDate);
            tesla = fileService.outputFileName(file); // returns String filename capitalized
            System.out.println("The best month for " + tesla + " was: " + dateOutput);
        }else if(minMax.equals("min")){
            statResult = fileService.getStatisticsInfo(file, "min");
            salesDate = fileService.getSalesDate(file, statResult);
            dateOutput = dateService.getDateFormat(salesDate);
            tesla = fileService.outputFileName(file); // returns String filename capitalized
            System.out.println("The worst month for " + tesla + " was: " + dateOutput);
        }
    }

    /** output total sales per year
     * @param file csv file
     * @param dateService date format year from yy -> yyyy
     * @param fileService get total per year sales
     */
    public void yearOutputReport(File file, DateService dateService, FileService fileService) {
        List<Integer> yearArray = fileService.getYears(file);
        for (Integer i : yearArray){
            System.out.println(dateService.getYearFormat(i)+ " -> " + fileService.totalPerYear(file, i));
        }
    }
}
