package com.wallace.learning.test.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 9:41
 */
public class TestngObject {
    private long count = 0;

    synchronized public long addOne() {
        this.count ++;
        return count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
