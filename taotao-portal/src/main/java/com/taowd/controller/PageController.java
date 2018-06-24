package com.taowd.controller;

import com.taowd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/16 22:50
 * @Version V1.0
 */
@Controller
public class PageController {


    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String showIndex(Model model) throws Exception {
        String result = contentService.getContentList();
        model.addAttribute("ad1", result);//前台通过el表达式获取值
        return "index";
    }

}
