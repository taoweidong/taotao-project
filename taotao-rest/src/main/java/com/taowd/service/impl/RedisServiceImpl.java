package com.taowd.service.impl;

import com.taowd.dao.JedisClient;
import com.taowd.service.RedisService;
import com.taowd.utils.ExceptionUtil;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName RedisServiceImpl
 * @Description 清除缓存数据
 * @Author Taowd
 * @Date 2018/6/25 23:44
 * @Version V1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisClient jedisClient;

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    /**
     * 修改了信息后调用此服务，清除缓存数据
     *
     * @param contentCid
     * @return
     */
    @Override
    public TaotaoResult syncContent(long contentCid) {
        try {
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }
}
