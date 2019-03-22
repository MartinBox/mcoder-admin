package com.mcoder.admin.service;

import com.mcoder.admin.entity.Menu;

import java.util.List;

/**
 * @author liuheng
 * @email liuheng@iboxpay.com
 * @date 2019/3/21 14:26
 */
public interface MenuService {
    List<Menu> getAllMenusByTree();

    /**
     * 获取用户可以访问的菜单
     *
     * @param id
     * @return
     */
    List<Menu> getUserAuthorityMenuByUserId(int id);

    /**
     * 根据用户获取可以访问的系统
     *
     * @param id
     * @return
     */
    List<Menu> getUserAuthoritySystemByUserId(int id);
}
