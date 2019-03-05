package com.wallace.learning.test.chapter2;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 9:40
 */
public class AgeCalculator {
    public static final long YEAR_MILLS = 1000L * 60 * 60 * 24 * 365;

    /**
     * 简易计算年龄的方法。实际是有bug的
     * @param birthDay
     * @return
     */
    public Integer calculateAge(Date birthDay) {
        if (birthDay == null) {
            throw new IllegalArgumentException("invalid birthDay: " + birthDay);
        }
        long nowMills = new Date().getTime();
        long birthDayMills = birthDay.getTime();
        if (birthDayMills > nowMills) {
            return 0;
        }
        return Math.toIntExact((nowMills - birthDayMills) / YEAR_MILLS);
    }
}
