package com.taowd.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/index")
    public String showIndex() throws Exception {
        return "index";
    }

}
