package com.taowd.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

/**
 * @ClassName JedisTest
 * @Description Jedis测试
 * @Author Taowd
 * @Date 2018/6/25 14:16
 * @Version V1.0
 */
public class JedisTest {

    @Test
    public void JedisTest() {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.230.130", 6379);
        //执行命令
        jedis.set("helo", "asdhajkhdkahdjak");
        jedis.set("helo3333", "asdhajkhdkahdjak测试一下");

        System.out.println(jedis.get("helo"));
        //关闭jedis
        jedis.close();
    }

    /**
     * jedis连接池测试
     */
    @Test
    public void JedisPoolTest() {
        JedisPool pool = new JedisPool("192.168.230.130", 6379);
        Jedis jedis = pool.getResource();

        jedis.set("张三", "ceshi ");
        System.out.println(jedis.get("helo"));

        jedis.close();
        pool.close();
    }

    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.230.130", 7001));
        nodes.add(new HostAndPort("192.168.230.130", 7002));
        nodes.add(new HostAndPort("192.168.230.130", 7003));
        nodes.add(new HostAndPort("192.168.230.130", 7004));
        nodes.add(new HostAndPort("192.168.230.130", 7005));
        nodes.add(new HostAndPort("192.168.230.130", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000000");
        String string = cluster.get("key1");

        System.out.println(string);

        cluster.close();
    }

    @Test
    public void testJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = jedisPool.getResource();
        String sting = jedis.get("helo");
        System.out.println(sting);
    }

    @Test
    public void testJedisCluster2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");
        String temp = jedisCluster.get("key1");
        System.out.println(temp);


    }
}
