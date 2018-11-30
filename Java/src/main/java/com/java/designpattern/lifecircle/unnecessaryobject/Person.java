package com.java.designpattern.lifecircle.unnecessaryobject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 是否是 出生高峰期的孩子
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public class Person {

    public static final int REPEATE_TIMES = 1000000;
    /**
     * 出生时间
     */
    private final Date birthDay;

    public Person(Date birthDay) {
        this.birthDay = birthDay;
    }

    /***

    /**
     * 禁止这样做
     * 每次调用该方法, 都会创建了 日历对象,及其消耗性能.
     * @date 27/01/2018
     * @author duanlianjie
     */
    public boolean isBabyBoomerWrong(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY,1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDay.compareTo(boomStart) >= 0 && birthDay.compareTo(boomEnd) < 0;
    }


    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY,1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    /**
     * 正确的方式
     *
     * @date 27/01/2018
     * @author duanlianjie
     */
    public boolean isBabyBoomerCorrect(){
        return birthDay.compareTo(BOOM_START) >= 0 && birthDay.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args){
        Person person = new Person(new Date(1948,2,3));

        long wrongBeforeTime = System.currentTimeMillis();

        for (int i = 0; i < REPEATE_TIMES; i ++ ){
            person.isBabyBoomerWrong();
        }

        long wrongAfterTime = System.currentTimeMillis();
        long wrongConsume = wrongAfterTime - wrongBeforeTime;
        System.out.println("isBabyBoomerWrong consume time: " + wrongConsume);

        for (int i = 0; i < 1000000; i ++ ){
            person.isBabyBoomerCorrect();
        }

        long correctAfterTime = System.currentTimeMillis();

        long correctConsume = correctAfterTime - wrongAfterTime;
        System.out.println("isBabyBoomerCorrect consume time: " + correctConsume);

        System.out.println("isBabyBoomerCorrect less time: " + (wrongConsume - correctConsume));

    }
}
