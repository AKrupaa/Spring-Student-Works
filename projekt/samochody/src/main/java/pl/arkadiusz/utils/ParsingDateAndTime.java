package pl.arkadiusz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ParsingDateAndTime {
//    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    public java.util.Date parseDate(String date) {
//        try {
//            return DATE_FORMAT.parse(date);
//        } catch (ParseException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

    /* String to java.util.Date */
    public java.util.Date parseTimestamp(String timestamp) {
        try {
            return DATE_TIME_FORMAT.parse(timestamp);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* java.util.Date to String */
    public String parseDate(java.util.Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    /* fetch actually system java.util.date */
    public java.util.Date getActualDate() {
        return new java.util.Date(System.currentTimeMillis());
    }

    public Long getDateInMilliseconds(java.util.Date date) {
        return date.getTime();
    }

    public Long getDateInMilliseconds(String sDate) {
        java.util.Date date = parseTimestamp(sDate);
        return getDateInMilliseconds(date);
    }

    public Long getDateInMilliseconds() {
        return System.currentTimeMillis();
    }

    public Long calculateDifferenceBetweenDateInstances(java.util.Date old, java.util.Date current) {

        long ms = current.getTime() - old.getTime();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(ms);
//
//        int mYear = calendar.get(Calendar.YEAR);
//        int mMonth = calendar.get(Calendar.MONTH);
//        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
//        int mHours = calendar.get(Calendar.HOUR_OF_DAY);
//        int mMinutes = calendar.get(Calendar.MINUTE);
//        int mSeconds = calendar.get(Calendar.SECOND);
//
//        String dateAndTimeToParse = mYear + "-" + mMonth + "-" + mDay + " " + mHours + ":" + mMinutes + ":" + mSeconds;

//        return parseTimestamp(dateAndTimeToParse);
        return ms;
    }
}
