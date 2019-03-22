package com.mcoder.admin.mapper;

import com.mcoder.admin.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends CustBaseMapper<Menu> {
    List<Menu> selectAllMenus();

    List<Menu> getAllMenusByTree();

    List<Menu> selectMenuByAuthorityId(@Param("authorityId") String authorityId, @Param("authorityType") String authorityType);

    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     *
     * @param userId
     * @return
     */
    List<Menu> selectAuthorityMenuByUserId(@Param("userId") int userId);

    /**
     * 根据用户和组的权限关系查找用户可访问的系统
     *
     * @param userId
     * @return
     */
    List<Menu> selectAuthoritySystemByUserId(@Param("userId") int userId);
}