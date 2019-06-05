package com.bin.mars.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 专门负责后台页面跳转的controller
 */
@Controller
public class IndexController {
    /**
     * 首页
     * 登录页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
