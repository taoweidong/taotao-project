package com.taowd.service.impl;

import com.taowd.pojo.ADItem;
import com.taowd.pojo.TbContent;
import com.taowd.service.ContentService;
import com.taowd.utils.HttpClientUtil;
import com.taowd.utils.JsonUtils;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ContentServiceImpl
 * @Description 调用服务层的服务根据内容分类id查询内容管理系统的内容
 * @Author Taowd
 * @Date 2018/6/24 12:12
 * @Version V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {


    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;

    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public String getContentList() {
        //调用服务
        String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
        //把json数据转换成对象
        TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
        List<ADItem> adItems = new ArrayList<ADItem>();
        if (taotaoResult.getStatus() == 200) {
            List<TbContent> contentList = (List<TbContent>) taotaoResult.getData();
            for (TbContent tbContent : contentList) {
                ADItem item = new ADItem();
                item.setHeight(240);
                item.setWidth(670);
                item.setSrc(tbContent.getPic());
                item.setHeightB(240);
                item.setWidth(550);
                item.setSrcB(tbContent.getPic2());
                item.setAlt(tbContent.getTitleDesc());
                item.setHref(tbContent.getUrl());
                adItems.add(item);
            }
        }
        return JsonUtils.objectToJson(adItems);
    }
}
