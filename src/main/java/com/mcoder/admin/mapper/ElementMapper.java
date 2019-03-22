package com.mcoder.admin.mapper;

import com.mcoder.admin.entity.Element;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElementMapper extends CustBaseMapper<Element> {
    List<Element> selectAuthorityElementByUserId(@Param("userId") String userId);

    List<Element> selectAuthorityMenuElementByUserId(@Param("userId") String userId, @Param("menuId") String menuId);

    List<Element> selectAuthorityElementByClientId(@Param("clientId") String clientId);

}