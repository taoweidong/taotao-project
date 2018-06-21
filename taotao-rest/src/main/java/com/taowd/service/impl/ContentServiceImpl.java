package com.taowd.service.impl;

import com.taowd.dao.TbContentMapper;
import com.taowd.pojo.TbContent;
import com.taowd.pojo.TbContentExample;
import com.taowd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<TbContent> getContentList(Long contentCid) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);

        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        return tbContents;
    }
}
