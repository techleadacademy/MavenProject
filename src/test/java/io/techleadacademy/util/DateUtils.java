package io.techleadacademy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public String getCurrentFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        Date date = new Date();
        return formatter.format(date);
    }


}
