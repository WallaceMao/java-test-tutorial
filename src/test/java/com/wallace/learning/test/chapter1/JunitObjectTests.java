package com.wallace.learning.test.chapter1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 9:51
 */
public class JunitObjectTests {
    private static JunitObject globalObject;

    /**
     * 在类的测试方法执行前只执行一次，一般可以做一些全局变量的初始化工作
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("----beforeAll----");
        globalObject = new JunitObject();
    }

    /**
     * 在类的测试方法都执行完成后执行，一般可以做一些清理工作
     */
    @AfterAll
    static void afterAll() {
        System.out.println("----afterAll----");
    }

    /**
     * 在每个测试方法执行前执行一次
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("----beforeEach----");
    }

    /**
     * 在每个测试方法执行后执行一次
     */
    @AfterEach
    void afterEach() {
        System.out.println("----afterEach----");
    }

    @Test
    void testMale() {
        String response = globalObject.sayHi("M");
        assertEquals("hey, man", response);
    }

    @Test
    void testFemale() {
        String response = globalObject.sayHi("F");
        assertEquals("hi, girl!", response);
    }

    @Test
    void testNoSex() {
        String response = globalObject.sayHi("???");
        assertEquals("hello", response);
    }

    @Disabled
    @Test
    void testIgnore() {
        assertEquals(1 + 1, 3);
    }
}
