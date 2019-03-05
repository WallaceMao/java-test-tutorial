package com.wallace.learning.test.chapter1;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 9:40
 */
public class JunitObject {

    /**
     * 根据不同性别打招呼的方法
     * @param sex
     * @return
     */
    public String sayHi(String sex) {
        switch (sex) {
            case "F":
                return "hi, girl!";
            case "M":
                return "hey, man";
            default:
                return "hello";
        }
    }
}
