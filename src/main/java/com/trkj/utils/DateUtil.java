package com.trkj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /*
     * @Title: 判断套餐时间
     * @Date:  2022/9/24 13:43
     * mealTime:套餐持续时间
     * time:套餐到期时间或办理时间
     *
     */
    public Date time(String mealTime,Date time) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(time);
        switch (mealTime)
        {
            case "一天":
                rightNow.add(Calendar.DATE ,1);
                break;
            case "两天":
                rightNow.add(Calendar.DATE ,2);
                break;
            case "三天":
                rightNow.add(Calendar.DATE ,3);
                break;
            case "四天":
                rightNow.add(Calendar.DATE ,4);
                break;
            case "五天":
                rightNow.add(Calendar.DATE ,5);
                break;
            case "六天":
                rightNow.add(Calendar.DATE ,6);
                break;
            case "一周":
                rightNow.add(Calendar.DATE ,7);
                break;
            case "两周":
                rightNow.add(Calendar.DATE ,14);
                break;
            case "三周":
                rightNow.add(Calendar.DATE ,21);
                break;
            case "一个月":
                rightNow.add(Calendar.MONTH ,1);
                break;
            case "两个月":
                rightNow.add(Calendar.MONTH ,2);
                break;
            case "三个月":
                rightNow.add(Calendar.MONTH ,3);
                break;
            case "四个月":
                rightNow.add(Calendar.MONTH ,4);
                break;
            case "五个月":
                rightNow.add(Calendar.MONTH ,5);
                break;
            case "六个月":
                rightNow.add(Calendar.MONTH ,6);
                break;
            case "七个月":
                rightNow.add(Calendar.MONTH ,7);
                break;
            case "八个月":
                rightNow.add(Calendar.MONTH ,8);
                break;
            case "九个月":
                rightNow.add(Calendar.MONTH ,9);
                break;
            case "十个月":
                rightNow.add(Calendar.MONTH ,10);
                break;
            case "十一个月":
                rightNow.add(Calendar.MONTH ,11);
                break;
            case "一年":
                rightNow.add(Calendar.YEAR ,1);
                break;
        }
        return rightNow.getTime();
    }
}
