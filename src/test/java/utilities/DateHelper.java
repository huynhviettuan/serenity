package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat SYSTEM_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatDate(String date) {
        String stringDate = null;
        try {
            Date formatDate = DEFAULT_FORMAT.parse(date);
            stringDate = SYSTEM_FORMAT.format(formatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stringDate;
    }
}
