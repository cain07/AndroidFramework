package com.cain.af.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gyfrx on 2017/8/11.
 */

public class TimeUtils {
    //    private static String[] weeks = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    private static String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private static long SPACE_TIME = 2 * 1000 * 60;

    /**
     * 根据时间字符串转化对应的字符格式
     *
     * @param flag        true为详情中格式  false为列表格式
     * @param receiveTime 时间字符串
     * @return
     */
    public static String parseToString(boolean flag, long receiveTime2, String receiveTime) {
//        long receiveMs = parseToMs(receiveTime);  //接受到时间对应的毫秒值
        long receiveMs = receiveTime2;  //接受到时间对应的毫秒值
        long nowTime = System.currentTimeMillis();  //当前日期的毫秒值
        long mondayTime = parseToMondayMs(new Date());//当前日期的一周内周一的毫秒值

        //今天  ---显示时分
        if (changeToStr(2, nowTime).equals(changeToStr(2, receiveMs))) {
            return changeToStr(1, receiveMs);
        }

        if (flag) {
            //本周   ---显示周几
            int count = getFormatedDateTime("EEEE", receiveMs);
            if (receiveMs > mondayTime) {
                return weeks[count] + "  " + changeToStr(1, receiveMs);
            } else {
                //直接显示年月日 时分
                return changeToStr(3, receiveMs);
            }
        } else {
            //本周   ---显示周几
            int count = getFormatedDateTime("EEEE", receiveMs);
            if (receiveMs > mondayTime) {
                return weeks[count];
            } else {
                //直接显示年月日
                return changeToStr(2, receiveMs);
            }
        }
    }


    /**
     * 毫秒值转化为字符串
     *
     * @param type   转化的类型 true 为时分  false 为年月日 时分
     * @param sstime long类型的时间
     * @return String时间
     */
    public static String changeToStr(int type, long sstime) {
        Date date = new Date(sstime);
        SimpleDateFormat sdf = null;
        switch (type) {
            case 1:
                sdf = new SimpleDateFormat("HH:mm");
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            default:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
        }
        return sdf.format(date);
    }

    /**
     * 根据毫秒值获得是一周内的周几
     *
     * @param dateTime
     * @return
     */
    public static int getFormatedDateTime(String pattern, long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
        String format = sDateFormat.format(new Date(dateTime + 0));
        for (int i = 0; i < 7; i++) {
            if (weeks[i].equals(format)) {
                return i;
            }
        }
        return 0;
    }


    /**
     * 根据时间字符串 获得毫秒值
     *
     * @param receiveTime 时间
     * @return 毫秒值
     */
    public static long parseToMs(String receiveTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(receiveTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 根据当前日期获取周一的毫秒值
     *
     * @param date
     * @return
     */
    public static long parseToMondayMs(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long fTime = null;
        try {
            Date parse = sdf.parse(sdf.format(date));
            int b = parse.getDay();
            fTime = parse.getTime() - b * 24 * 3600000;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fTime + (24 * 3600000);
    }

    /**
     * 判断两个时间是否是间隔2分钟
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isSpaceTwo(String time1, String time2) {
        long longTime1 = Long.parseLong(time1);
        long longTime2 = Long.parseLong(time2);
        if (Math.abs(longTime1 - longTime2) > SPACE_TIME) {
            return true;
        }
        return false;
    }
}
