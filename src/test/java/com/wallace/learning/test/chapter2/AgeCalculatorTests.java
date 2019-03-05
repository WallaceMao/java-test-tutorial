package com.wallace.learning.test.chapter2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 11:06
 */
public class AgeCalculatorTests {
    private static AgeCalculator calculator;
    private static Calendar now;

    @BeforeAll
    private static void beforeAll() {
        calculator = new AgeCalculator();
        now = Calendar.getInstance();
        now.setTime(new Date());
    }

    /**
     * 普通测试，测试正常的年龄计算
     */
    @Test
    void testCommonUsage() {
        final int YEAR_DIFF = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.set(now.get(Calendar.YEAR) - YEAR_DIFF, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();
        int age = calculator.calculateAge(birthDate);

        assertThat(age).isEqualTo(YEAR_DIFF);
    }

    /**
     * 测试异常情况
     */
    @Test
    void testException() {
        //  传参大于当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(now.get(Calendar.YEAR) + 1, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();
        int age = calculator.calculateAge(birthDate);
        assertThat(age).isEqualTo(0);

        //  传参为null时
        assertThatThrownBy(() -> {
            calculator.calculateAge(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("invalid birthDay");
    }

    /**
     * 测试由于闰年问题导致的bug
     */
    @Test
    void testError() {
        final int YEAR_DIFF = 4;
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.setTime(new Date());
        tomorrow.add(Calendar.DATE, 1);
        Calendar calendar = Calendar.getInstance();
        calendar.set(now.get(Calendar.YEAR) - YEAR_DIFF, tomorrow.get(Calendar.MONTH), tomorrow.get(Calendar.DATE));
        Date birthDate = calendar.getTime();
        int age = calculator.calculateAge(birthDate);
        assertThat(age).isEqualTo(YEAR_DIFF - 1);
    }
}
