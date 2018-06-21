package com.taowd.controller;

import com.taowd.pojo.TbContent;
import com.taowd.service.ContentService;
import com.taowd.utils.ExceptionUtil;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/21 23:06
 * @Version V1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long contentCategoryId) {

        try {
            List<TbContent> contentList = contentService.getContentList(contentCategoryId);

            return TaotaoResult.ok(contentList);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }

    }

}
