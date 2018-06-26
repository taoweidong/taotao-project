package com.taotao.search.controller;

import com.taotao.search.service.ItemService;
import com.taowd.utils.ExceptionUtil;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ItemController
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/26 22:58
 * @Version V1.0
 */
@Controller
@RequestMapping("/manager")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 导入索引库
     *
     * @return
     */
    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAll() {
        TaotaoResult result = null;
        try {
            result = itemService.importItemToIndex();
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

}
