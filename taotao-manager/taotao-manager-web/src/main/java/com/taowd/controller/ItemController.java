package com.taowd.controller;

import com.taotao.service.ItemService;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemDesc;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ItemController
 * @Description 商品信息控制器
 * @Author Taowd
 * @Date 2018/6/7 22:19
 * @Version V1.0
 */
@Controller
@RequestMapping("/item")//注意如果不使用此注解有可能 Spring扫描不到这个Controller
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    /**
     * 新增商品功能
     *
     * @param item 商品信息
     * @param desc 商品描述
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem item, String desc) {
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);

        TaotaoResult result = itemService.addItem(item, tbItemDesc);
        return result;
    }

    /**
     * 查询商品列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) {

        logger.info("查询商品列表：page" + page + " row" + rows);
        return itemService.getItemList(page, rows);
    }
}
