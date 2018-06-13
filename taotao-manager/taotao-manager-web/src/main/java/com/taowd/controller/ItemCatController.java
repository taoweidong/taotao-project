package com.taowd.controller;

import com.taotao.service.ItemCatService;
import com.taowd.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ItemCatController
 * @Description 查询商品类目
 * @Author Taowd
 * @Date 2018/6/9 21:46
 * @Version V1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List categoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List catList = new ArrayList();
        //查询数据库
        List<TbItemCat> list = itemCatService.getItemCatList(parentId);
        for (TbItemCat item : list) {
            Map node = new HashMap();
            node.put("id", item.getId());
            node.put("text", item.getName());
            //如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
            node.put("state", item.getIsParent() ? "closed" : "open");
            catList.add(node);
        }
        return catList;
    }

}
