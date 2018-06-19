package com.taotao.service.impl;

import com.taotao.service.ContentCategoryService;
import com.taowd.dao.TbContentCategoryMapper;
import com.taowd.pojo.TbContentCategory;
import com.taowd.pojo.TbContentCategoryExample;
import com.taowd.utils.EasyUITreeNode;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ContentCategoryServiceImpl
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/19 23:11
 * @Version V1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    /**
     * 根据parentid查询内容分类列表
     *
     * @param parentid
     * @return
     */
    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentid) {
        //根据parentid查询内容分类列表
        TbContentCategoryExample example;
        example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            //判断是否是父节点
            if (tbContentCategory.getIsParent()) {
                node.setState("closed");
            } else {
                node.setState("open");
            }
            resultList.add(node);
        }
        return resultList;

    }

    @Override
    public TaotaoResult addNode(long parentid, String name) {
        Date date = new Date();
        //添加一个新节点
        //创建一个节点对象
        TbContentCategory node = new TbContentCategory();
        node.setName(name);
        node.setParentId(parentid);
        node.setIsParent(false);
        node.setCreated(date);
        node.setUpdated(date);
        node.setSortOrder(1);
        //状态。可选值:1(正常),2(删除)
        node.setStatus(1);
        //插入新节点。需要返回主键
        contentCategoryMapper.insert(node);
        //判断如果父节点的isparent不是true修改为true
        //取父节点的内容
        TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentid);
        if (!parentNode.getIsParent()) {
            parentNode.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parentNode);
        }
        //把新节点返回
        return TaotaoResult.ok(node);

    }
}
