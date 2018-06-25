package com.taowd.service.impl;

import com.taowd.dao.JedisClient;
import com.taowd.dao.TbContentMapper;
import com.taowd.pojo.TbContent;
import com.taowd.pojo.TbContentExample;
import com.taowd.service.ContentService;
import com.taowd.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ContentServiceImpl
 * @Description 内容管理
 * @Author Taowd
 * @Date 2018/6/21 23:03
 * @Version V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    /**
     * 添加缓存功能
     */
    @Autowired
    private JedisClient jedisClient;

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Override
    public List<TbContent> getContentList(Long contentCid) {

        //从缓存中取数据
        try {
            String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
            if (!StringUtils.isBlank(result)) {
                List<TbContent> contentList = JsonUtils.jsonToList(result, TbContent.class);
                return contentList;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);

        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);


        //向缓存中添加数据
        try {
            //把list转换成字符串
            String cacheString = JsonUtils.objectToJson(tbContents);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tbContents;
    }
}
