package com.xcs.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author xcs
 * @date 2024年01月26日 11时34分
 **/
@Controller
public class IndexController {

    /**
     * 配置url通配符，拦截多个地址
     *
     * @return html
     */
    @RequestMapping(value = {"/", "/{path:[^.]*}"})
    public String index() {
        return "index";
    }
}
