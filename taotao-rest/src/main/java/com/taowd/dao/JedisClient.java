package com.taowd.dao;

/**
 * @ClassName JedisClient
 * @Description Redis接口
 * @Author Taowd
 * @Date 2018/6/25 23:05
 * @Version V1.0
 */
public interface JedisClient {
    /**
     * 获取key
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置key
     *
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long incr(String key);

    /**
     * 设置key的过期时间
     *
     * @param key
     * @param second
     * @return
     */
    long expire(String key, int second);

    /**
     * 检查key是否过期
     *
     * @param key
     * @return
     */
    long ttl(String key);

    long del(String key);

    long hdel(String hkey, String key);
}
