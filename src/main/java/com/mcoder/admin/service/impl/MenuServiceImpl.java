package com.mcoder.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcoder.admin.entity.Menu;
import com.mcoder.admin.mapper.MenuMapper;
import com.mcoder.admin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuheng
 * @email liuheng@iboxpay.com
 * @date 2019/3/21 14:29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<Menu> getAllMenusByTree() {
        //return baseMapper.selectList(new LambdaQueryWrapper<Menu>().gt(Menu::getId, "1"));
        return baseMapper.getAllMenusByTree();
    }

    @Override
    public List<Menu> getUserAuthorityMenuByUserId(int id) {
        return null;
    }

    @Override
    public List<Menu> getUserAuthoritySystemByUserId(int id) {
        return null;
    }
}
