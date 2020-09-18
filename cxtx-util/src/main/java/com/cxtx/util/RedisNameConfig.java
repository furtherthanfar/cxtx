package com.cxtx.util;


import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description
 */
public class RedisNameConfig {

    public static final String PRE = "CXTX:";
    public static final String SUF_STRING = ":STRING";
    public static final String SUF_HASH = ":HASH";
    public static final StringRedisSerializer STRING_REDIS_SERIALIZER = new StringRedisSerializer();

}
