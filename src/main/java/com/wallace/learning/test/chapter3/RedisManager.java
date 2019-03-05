package com.wallace.learning.test.chapter3;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 11:59
 */
public class RedisManager {
    private int poolSize;

    public void setVal(String key, String val) {
        System.out.println("=====set to redis====");
        //  ...
    }

    public String getVal(String key) {
        System.out.println("=====get from redis===");
        //  ...
        return null;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
