package com.hoarse.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 1.类的用途:
 * 2.author:Liuxiaoyu
 * 3.2016/12/28
 */
public class DateUtils {

    public static String formatDate(String date){
        SimpleDateFormat dateFm1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFm2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return dateFm2.format(dateFm1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatTime(String date){
        SimpleDateFormat dateFm1 = new SimpleDateFormat("HHmm");
        SimpleDateFormat dateFm2 = new SimpleDateFormat("HH:mm");
        try {
            return dateFm2.format(dateFm1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
