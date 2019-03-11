package com.mcoder.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuheng
 * @Description: TODO
 * @date 2019/3/11 17:43
 */
@Controller
@RequestMapping
public class IndexController {
    @GetMapping(value = "/index")
    public String index() {
        return "/index";
    }
}
