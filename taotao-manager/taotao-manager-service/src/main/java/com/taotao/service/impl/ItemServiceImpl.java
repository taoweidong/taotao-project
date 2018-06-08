package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.service.ItemService;
import com.taowd.dao.TbItemMapper;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemExample;
import com.taowd.utils.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/7 22:10
 * @Version V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    /**
     * 根据商品Id查询商品信息
     *
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(Long itemId) {
//        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
//        return tbItem;

        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        if (tbItems != null && tbItems.size() > 0) {
            TbItem tbItem = tbItems.get(0);
            return tbItem;
        }
        return null;
    }

    /**
     * 分页查询商品信息
     *
     * @param pageIndex 第几页
     * @param pageCount 本页条目数
     * @return
     */
    @Override
    public EasyUIResult getItemList(Integer pageIndex, Integer pageCount) {
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(pageIndex, pageCount);
        //调用Mybatis查询所有数据
        List<TbItem> itemList = tbItemMapper.selectByExample(new TbItemExample());
        //用PageInfo对结果进行包装
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(itemList);
        //获取总条目
        Long pageSum = pageInfo.getTotal();
        //返回的结果对象
        EasyUIResult easyUIResult = new EasyUIResult(pageSum, itemList);
        return easyUIResult;
    }
}
