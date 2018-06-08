package com.taotao.service;

import com.taowd.pojo.TbItem;

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
}
