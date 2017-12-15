package com.sf.bgp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 01304522 on 2017/12/15.
 */
public class DateUtil {
    private Logger log = LoggerFactory.getLogger(getClass());

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得当前日期的后几天
     * @param date
     * @return
     *
     */
    public static Date getCurrentTimeBeforeDay(Date date, int num){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE,day + num);
        Date dateSwitch = null;
        try {
            dateSwitch = sdf.parse(sdf.format(c.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateSwitch;
    }
}
