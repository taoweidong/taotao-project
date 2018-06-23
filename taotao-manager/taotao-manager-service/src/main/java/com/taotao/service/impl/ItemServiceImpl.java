package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.service.ItemService;
import com.taowd.dao.TbItemDescMapper;
import com.taowd.dao.TbItemMapper;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemDesc;
import com.taowd.pojo.TbItemExample;
import com.taowd.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

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

    @Override
    public TaotaoResult addItem(TbItem item, TbItemDesc itemDesc) {
        try {
            //生成商品id
            //可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
            Long itemId = IDUtils.genItemId();
            //补全不完整的字段
            item.setId(itemId);
            item.setStatus((byte) 1);
            Date date = new Date();
            item.setCreated(date);
            item.setUpdated(date);
            //把数据插入到商品表
            tbItemMapper.insert(item);

            //添加商品描述
            itemDesc.setItemId(itemId);
            itemDesc.setCreated(date);
            itemDesc.setUpdated(date);
            //把数据插入到商品描述表
            tbItemDescMapper.insert(itemDesc);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }

    /**
     * 更新操作
     *
     * @param item
     * @param tbItemDesc
     * @return
     */
    @Override
    public TaotaoResult updateItem(TbItem item, TbItemDesc tbItemDesc) {
        try {
            //生成商品id
            //可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
            //补全不完整的字段
            item.setStatus((byte) 1);
            Date date = new Date();
            item.setUpdated(date);
            item.setCreated(date);
            //更新数据
            tbItemMapper.updateByPrimaryKey(item);

            //添加商品描述
            tbItemDesc.setCreated(date);
            tbItemDesc.setUpdated(date);

            System.out.println("待更新的数据：" + JsonUtils.objectToJson(tbItemDesc));

            //更新描述
            tbItemDescMapper.updateByPrimaryKey(tbItemDesc);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult getDescById(Long id) {

        TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);

        return TaotaoResult.ok(tbItemDesc);
    }

    @Override
    public TaotaoResult deleteItemById(String[] ids) {
        try {
            tbItemMapper.deleteById(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }
}
