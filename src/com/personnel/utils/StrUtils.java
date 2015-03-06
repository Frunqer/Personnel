package com.personnel.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 工具类
 * @author zhouzhenjiang
 *
 */
public class StrUtils {
    
    
    /**
     * 将日期格式化为指定的String类型
     * @param date
     * @return
     */
    public static String formatDateToString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    
    /**
     * 将字符串转化为日期格式
     * @param dateStr
     * @return
     */
    public static Date formatStrToDate(String dateStr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
           date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        date = java.sql.Date.valueOf(dateStr);
        return date;
    }

}
