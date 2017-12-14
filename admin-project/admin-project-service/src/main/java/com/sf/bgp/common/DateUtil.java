package com.sf.bgp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jacky
 *
 * @date 2017/11/20
 */
public class DateUtil {

    private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat dateformats = new SimpleDateFormat("yyyyMMddHH");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得当前日期的前一天
     * @param date
     * @return
     *
     */
    public static String getCurrentDayBefore(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE,day - 1);
        String dayBefore = dateformat.format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得当前日期的前几个小时
     * @param date
     * @return
     *
     */
    public static String getCurrentTimeBeforeHour(Date date,int num){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.HOUR);
        c.set(Calendar.HOUR,day - num);
        String dayBefore = dateformats.format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得当前日期的前几天
     * @param date
     * @return
     *
     */
    public static Date getCurrentTimeBeforeDay(Date date,int num){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE,day - num);
        Date dateSwitch = null;
        try {
            dateSwitch = sdf.parse(sdf.format(c.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateSwitch;
    }

    /**
     * 日期格式化yyyyMMdd
     * @param dateStr
     * @return
     *
     */
    public static String dateFormat(String dateStr){
        Date date = null;
        try {
           date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateformat.format(date);
    }

    /**
     * 日期格式化yyyyMMddHH
     * @param dateStr
     * @return
     *
     */
    public static String dateFormat1(String dateStr){
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateformats.format(date);
    }


    public static void main(String[] args) {
        System.out.println(getCurrentTimeBeforeHour(new Date(),2));
        System.out.println(getCurrentTimeBeforeDay(new Date(),30));
        System.out.println(dateFormat1("2017-11-28 13:00:00"));
    }
}
