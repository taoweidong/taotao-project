package com.taowd.service;

import com.taowd.utils.TaotaoResult;

/**
 * @ClassName RedisService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/25 23:43
 * @Version V1.0
 */
public interface RedisService {
    TaotaoResult syncContent(long contentCid);
}
