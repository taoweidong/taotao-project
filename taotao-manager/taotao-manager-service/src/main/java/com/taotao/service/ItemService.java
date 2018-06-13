package com.taotao.service;

import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemDesc;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/7 22:08
 * @Version V1.0
 */
public interface ItemService {

    /**
     * 根据商品Id查询商品信息
     *
     * @param itemId
     * @return
     */
    TbItem getItemById(Long itemId);

    /**
     * 分页查询所有数据
     *
     * @param pageIndex 第几页
     * @param pageCount 本页条目数
     * @return 数据集合
     */
    EasyUIResult getItemList(Integer pageIndex, Integer pageCount);

    /**
     * 添加数据
     *
     * @param item
     * @param itemDesc
     * @return
     */
    TaotaoResult addItem(TbItem item, TbItemDesc itemDesc);
}
