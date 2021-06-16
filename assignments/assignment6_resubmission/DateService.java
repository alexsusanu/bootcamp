import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {
    private String month, fullDate;
    private Integer year;

    public DateService() { };

    public DateService(String month, Integer year, String fullDate) {
        this.month = month;
        this.year = year;
        this.fullDate = fullDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFullDate(){
        return fullDate;
    }

    public void setFullDate(String fullDate){
        this.fullDate = fullDate;
    }
    /**
     * format date for report
     *
     * @param salesDate date taken from csv file in format MMM-yy
     * @return date as string in format yyyy-MM
     */
    public String getDateFormat(String salesDate) {
        String output = null;
        SimpleDateFormat fileFormatter = new SimpleDateFormat("MMM-yy", Locale.ENGLISH);
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM");
        try {
            Date date = fileFormatter.parse(salesDate);
            output = outputFormatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * gets the year in format yy
     *
     * @param year as integer
     * @return year as string in format yyyy
     */
    public Integer getYearFormat(Integer year) {
        String output = null;
        SimpleDateFormat fileFormatter = new SimpleDateFormat("yy", Locale.ENGLISH);
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy");
        try {
            Date date = fileFormatter.parse(String.valueOf(year));
            output = outputFormatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(output);
    }
}