package com.mcoder.admin.service;

import com.mcoder.admin.entity.Element;

import java.util.List;

public interface ElementService {
    List<Element> getAuthorityElementByUserId(String userId);

    List<Element> getAuthorityElementByUserId(String userId, String menuId);
}
