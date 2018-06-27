package com.taotao.search.controller;

import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.ItemSearchService;
import com.taotao.search.service.ItemService;
import com.taowd.utils.ExceptionUtil;
import com.taowd.utils.TaotaoResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private ItemSearchService itemSearchService;


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult search(@RequestParam("q") String queryString,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "60") Integer rows) {
        //查询条件不能为空
        if (StringUtils.isBlank(queryString)) {
            return TaotaoResult.build(400, "查询条件不能为空");
        }
        SearchResult searchResult = null;
        try {
            queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            searchResult = itemSearchService.search(queryString, page, rows);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok(searchResult);

    }


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
