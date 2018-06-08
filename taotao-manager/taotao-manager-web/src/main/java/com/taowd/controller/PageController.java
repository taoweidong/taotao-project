package com.taowd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description 实现页面跳转功能
 * @Author Taowd
 * @Date 2018/6/8 14:08
 * @Version V1.0
 */
@Controller("/test")
public class PageController {

    /**
     * 打开首页，注意此处返回的逻辑视图
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 页面跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
