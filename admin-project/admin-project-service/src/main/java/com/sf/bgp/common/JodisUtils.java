package com.sf.bgp.common;

import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author wujiang
 * @version 1.0.0
 * @date 2017/9/5
 */
@Service
public class JodisUtils implements InitializingBean{
    private static Logger logger = LoggerFactory.getLogger(JodisUtils.class);

    @Value("${zk}")
    private String zk;
    @Value("${zkSessionTimeout}")
    private int zkSessionTimeout;
    @Value("${proxyPath}")
    private String proxyPath;

    private JedisResourcePool jedisResourcePool;
    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    private static final int expireMsecs = 60 * 1000;
    private static final int timeoutMsecs = 0;
    private volatile boolean locked = false;

    public Jedis getJedis(){
        return jedisResourcePool.getResource();
    }

    public boolean lock(Jedis jedis,String lockKey) throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiresStr = String.valueOf(expires);
            if (jedis.setnx(lockKey, expiresStr) > 0) {
                locked = true;
                return true;
            }
            jedis.expire(lockKey,60*5); //防止因为意外没有删掉锁
            String currentValueStr = jedis.get(lockKey); //redis里的时间
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                String oldValueStr = jedis.getSet(lockKey, expiresStr);
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    locked = true;
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }
        return false;
    }

    public void unlock(String lockKey) {
        try (Jedis jedis = getJedis()){
            if (locked) {
                Thread.sleep(2000);
                jedis.del(lockKey);
                locked = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getLockKey(String methodName){
        return DateFormatUtils.format(new Date(),"yyyyMMddHHmm") + methodName;
    }

    public void close(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jedisResourcePool =  RoundRobinJedisPool.create().curatorClient(zk, zkSessionTimeout).zkProxyDir(proxyPath).build();
    }

    public static void main(String[] args) {
        JedisResourcePool jedisResourcePool =  RoundRobinJedisPool.create().curatorClient("10.202.94.16:2181", 30000).zkProxyDir("/jodis/codis-wujiang").build();
        try(Jedis jedis = jedisResourcePool.getResource()){
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

