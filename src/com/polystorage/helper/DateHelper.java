package com.polystorage.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateHelper {

    public static String toSqlDate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate.toString();
    }

    public static java.util.Date toDate(String date) {
        java.util.Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return utilDate;
    }
}
