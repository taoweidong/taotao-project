package com.taotao.service.impl;

import com.taotao.service.ItemCatService;
import com.taowd.dao.TbItemCatMapper;
import com.taowd.pojo.TbItemCat;
import com.taowd.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ItemCatServiceImpl
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/9 21:44
 * @Version V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //根据parentid查询子节点
        criteria.andParentIdEqualTo(parentId);
        //返回子节点列表
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        return list;

    }
}
