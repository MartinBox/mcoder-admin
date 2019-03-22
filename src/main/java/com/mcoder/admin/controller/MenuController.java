package com.mcoder.admin.controller;

import com.mcoder.admin.entity.Menu;
import com.mcoder.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuheng
 * @email liuheng@iboxpay.com
 * @date 2019/3/22 11:09
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/home")
    public String home() {

        return "/pages/menu_page";
    }

    /* @GetMapping(value = "/page")
     @ResponseBody
     public TableResultResponse<Menu> list(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int offset) {
         Page pageResult = PageHelper.startPage(offset, limit);
         List<Menu> list = menuService.getUserAuthorityMenuByUserId(1);
         return new TableResultResponse<>(pageResult.getTotal(), list);

         *//*List<Menu> list = menuService.getUserAuthorityMenuByUserId(1);
        return new TableResultResponse<>(list.size(), list);*//*
    }*/
    @GetMapping(value = "/page")
    @ResponseBody
    public Map<String, List<Menu>> list(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int offset) {
        List<Menu> list = menuService.getUserAuthorityMenuByUserId(1);
        Map<String, List<Menu>> listMap = new HashMap<>();
        listMap.put("data", list);
        return listMap;
        /*List<Menu> list = menuService.getUserAuthorityMenuByUserId(1);
        return new TableResultResponse<>(list.size(), list);*/
    }
}
