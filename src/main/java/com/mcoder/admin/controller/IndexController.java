package com.mcoder.admin.controller;

import com.mcoder.admin.entity.Menu;
import com.mcoder.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuheng
 * @Description: TODO
 * @date 2019/3/11 17:43
 */
@Controller
@RequestMapping
public class IndexController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/index")
    public ModelAndView index() {
        List<Menu> list = menuService.getAllMenusByTree();
        list = list.stream().filter(menu ->!StringUtils.isEmpty(menu.getTitle())).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("name", "hello world");
        modelAndView.addObject("menuList", list);
        return modelAndView;
    }
}
