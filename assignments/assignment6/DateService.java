import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {

    public DateService(){};

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
}
