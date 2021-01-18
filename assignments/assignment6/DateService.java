import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {

    public DateService(){};

    /** format date for report
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

    /** gets the year in format yy
     * @param year as integer
     * @return year as string in format yyyy
     */
    public String getYearFormat(Integer year) {
        String output = null;
        SimpleDateFormat fileFormatter = new SimpleDateFormat("yy", Locale.ENGLISH);
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy");
        try {
            Date date = fileFormatter.parse(String.valueOf(year));
            output = outputFormatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }
}
