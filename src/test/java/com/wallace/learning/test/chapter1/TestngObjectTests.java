package com.wallace.learning.test.chapter1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 10:41
 */
public class TestngObjectTests {
    private TestngObject globalObject;

    @BeforeClass
    private void beforeClass() {
        globalObject = new TestngObject();
    }

    @AfterClass
    private void afterClass() {
        assertEquals(20, globalObject.getCount());
    }

    /**
     * 测试并发
     */
    @Test(threadPoolSize = 5, invocationCount = 20, timeOut = 10000)
    public void testConcurrent() {
        globalObject.addOne();
        System.out.println("----current count: " + globalObject.getCount());
    }
}
