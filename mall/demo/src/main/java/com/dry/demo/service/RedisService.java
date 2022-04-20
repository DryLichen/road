package com.dry.demo.service;

/**
 * redis形式的service，对象和数组都以json形式存储
 */
public interface RedisService {

    // save data
    void set (String key, String value);

    // access data
    String get (String key);

    // set time-out
    boolean expire (String key, long expire);

    // delete data
    void remove (String key);

    // increment, where length of step is delta
    long increment (String key, long delta);
}
