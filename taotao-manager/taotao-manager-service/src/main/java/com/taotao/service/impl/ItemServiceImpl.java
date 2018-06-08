package com.taotao.service.impl;

import com.taotao.service.ItemService;
import com.taowd.dao.TbItemMapper;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemExample;
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
}
