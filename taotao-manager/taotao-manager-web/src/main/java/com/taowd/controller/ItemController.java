package com.taowd.controller;

import com.taotao.service.ItemService;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemDesc;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.JsonUtils;
import com.taowd.utils.TaotaoResult;
import org.apache.commons.lang3.StringUtils;
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
     * 更新操作
     *
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateItem(TbItem item, String desc) {
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(item.getId());

        System.out.println(desc);

        logger.info("条目信息：" + JsonUtils.objectToJson(item));

        logger.info("描述信息：" + JsonUtils.objectToJson(tbItemDesc));
        TaotaoResult result = itemService.updateItem(item, tbItemDesc);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public TaotaoResult editItem(TbItem item, String desc) {
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(item.getId());

        TaotaoResult result = itemService.addItem(item, tbItemDesc);
        return result;
    }

    @RequestMapping("query/item/desc/{id}")
    @ResponseBody
    public TaotaoResult getDesc(@PathVariable Long id) {

        TaotaoResult result = itemService.getDescById(id);
        return result;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteItem(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return TaotaoResult.build(500, "删除失败，id不能为空！");
        }
        String[] idsArr = ids.split(",");
        TaotaoResult result = itemService.deleteItemById(idsArr);
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
