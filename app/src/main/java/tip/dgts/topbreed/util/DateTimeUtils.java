package tip.dgts.topbreed.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author pocholomia
 * @since 13/09/2016
 */
public class DateTimeUtils {

    public static final String FULL_23_HR_DATE = "yyyy-MM-dd";
    public static final String DATE_ONLY = "MMM dd, yyyy";
    public static final String DATE_NUM_ONLY = "MM.dd.yyyy";


    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String endTime(Calendar cal) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        return dateFormat.format(cal.getTime());

    }

    public static String timeConvert(String time) {

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            final Date dateObj = sdf.parse(time);

            return (new SimpleDateFormat("K:mm a").format(dateObj));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }

    public static String getTimeOnly(String dateString) {
        return convertDateToString("hh:mm a", convertTransactionStringDate(dateString, FULL_23_HR_DATE));
    }

    public static String geShortDateTime(String dateString) {
        return convertDateToString("MM/dd/yy h:mm a", convertTransactionStringDate(dateString, FULL_23_HR_DATE));
    }


    public static String getShortBirthDateOnly(String dateString) {
        return convertDateToString(DATE_ONLY, convertTransactionStringDate(dateString, "yyyy-MM-dd"));
    }

    public static Calendar convertTransactionStringDate(String dateString, String format) {
        Date date = convertStringDate(dateString, format);
        if (date == null) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date convertStringDate(String dateString, String format) {
        Date date = null;
        try {
            date = getSimpleDateFormat(format).parse(dateString);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.d("dateString: ", dateString + "");
            e.printStackTrace();
        }
        return date;
    }

    public static String convertDateToString(String format, Calendar calendar) {
        if (calendar == null) return "";
        return getSimpleDateFormat(format).format(calendar.getTime());
    }

    public static SimpleDateFormat getSimpleDateFormat(String format) {
        return new SimpleDateFormat(format, Locale.ENGLISH);
    }

    public static String getDateOnlyToday() {
        return convertDateToString("yyyy-MM-dd", Calendar.getInstance());
    }

    public static String convertTime(String time) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            final Date dateObj = sdf.parse(time);
            //DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            return new SimpleDateFormat("hh:mm a").format(dateObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    public static String toReadable(String dateToConvert) {
        String convertedDate;
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date = null;
        try {
            date = targetFormat.parse(dateToConvert);


            SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd", Locale.US);
            convertedDate = formatter.format(date);
            return convertedDate.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


    public static String dateToReadable(Date dateToConvert) {
        /*String convertedDate;
        //String[] arr = dateToConvert.split(" ");
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
        Date date = null;
        *//*try {
            date = targetFormat.parse(dateToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String convertedDate;
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd", Locale.US);
            convertedDate = formatter.format(dateToConvert);
        } catch (NullPointerException e) {
            e.printStackTrace();
            convertedDate = "";
        }

        return convertedDate.toUpperCase();
    }


    public static String toAge(String dateToConvert) {
        String[] arr = dateToConvert.split("-");
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR) - Integer.parseInt(arr[0]);
        return year + " years old";
    }

    public static String dateToAMorPM(Date dateToConvert) {
        String convertedDate;
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("h:mm a", Locale.US);
            convertedDate = formatter.format(dateToConvert);
        } catch (NullPointerException e) {
            e.printStackTrace();
            convertedDate = "";
        }

        return convertedDate.toUpperCase();
    }

    public static String stringToAMorPM(String dateToConvert) {
        String convertedDate = null;
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            final Date date = sdf.parse(dateToConvert);
            SimpleDateFormat formatter = new SimpleDateFormat("h:mm a", Locale.US);
            convertedDate = formatter.format(date);
        } catch (NullPointerException e) {
            e.printStackTrace();
            convertedDate = "";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return convertedDate.toUpperCase();
    }

    public static Date getDateToday() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = sdfs.format(calendar.getTime());
        Date converted = null;
        try {
            converted = sdfs.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return converted;
    }
}
