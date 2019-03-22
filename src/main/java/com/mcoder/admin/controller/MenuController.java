package com.mcoder.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuheng
 * @email liuheng@iboxpay.com
 * @date 2019/3/22 11:09
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @GetMapping(value = "/list")
    public String list() {

        return "/pages/menu_page";
    }
}
