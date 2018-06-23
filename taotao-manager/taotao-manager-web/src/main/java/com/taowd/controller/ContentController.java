package com.taowd.controller;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/21 21:38
 * @Version V1.0
 */

import com.taotao.service.ContentService;
import com.taowd.pojo.TbContent;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 查询内容管理
     *
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIResult queryList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows, Long categoryId) {
        return contentService.queryList(page, rows, categoryId);
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult save(TbContent content) {
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }

    /**
     * 修改
     *
     * @param content
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public TaotaoResult edit(TbContent content) {
        TaotaoResult result = contentService.updateContent(content);
        return result;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult delete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return TaotaoResult.build(500, "删除失败，id不能为空！");
        }
        String[] idsArr = ids.split(",");
        TaotaoResult result = contentService.deleteContent(idsArr);
        return result;
    }
}
