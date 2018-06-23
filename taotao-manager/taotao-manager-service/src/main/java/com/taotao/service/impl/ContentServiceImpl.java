package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.service.ContentService;
import com.taowd.dao.TbContentMapper;
import com.taowd.pojo.TbContent;
import com.taowd.pojo.TbContentExample;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ContentServiceImpl
 * @Description 内容管理
 * @Author Taowd
 * @Date 2018/6/21 21:44
 * @Version V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public EasyUIResult queryList(Integer pageIndex, Integer pageCount, Long categoryId) {
        //获取第一页 10条内容
        PageHelper.startPage(pageIndex, pageCount);
        //创建查询条件
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //调用MyBatis查询所有数据  根据id查询
        List<TbContent> itemList = tbContentMapper.selectByExample(example);
        //包装查询结果
        PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(itemList);
        //获取总条数
        Long pageSum = pageInfo.getTotal();
        //封装返回结果
        EasyUIResult easyUIResult = new EasyUIResult(pageSum, itemList);

        return easyUIResult;
    }

    /**
     * 插入内容
     *
     * @param content
     * @return
     */
    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //插入操作
        tbContentMapper.insert(content);

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContent(TbContent content) {
        //补全内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //插入操作
        tbContentMapper.updateByPrimaryKey(content);
        return TaotaoResult.ok();
    }

    /**
     * 删除内容
     *
     * @param ids
     * @return
     */
    @Override
    public TaotaoResult deleteContent(String[] ids) {

        tbContentMapper.deleteByIds(ids);

        return TaotaoResult.ok();
    }
}
