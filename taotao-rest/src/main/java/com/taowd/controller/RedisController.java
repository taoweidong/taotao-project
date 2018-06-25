package com.taowd.controller;

import com.taowd.service.RedisService;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RedisController
 * @Description 缓存同步类
 * @Author Taowd
 * @Date 2018/6/25 23:46
 * @Version V1.0
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/content/{contentCid}")
    @ResponseBody
    public TaotaoResult contentCacheSync(@PathVariable Long contentCid) {
        TaotaoResult result = redisService.syncContent(contentCid);
        return result;
    }
}
