package com.mcoder.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcoder.admin.entity.Element;
import com.mcoder.admin.mapper.ElementMapper;
import com.mcoder.admin.service.ElementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuheng
 * @email liuheng@iboxpay.com
 * @date 2019/3/21 14:42
 */
@Service
public class ElementServiceImpl extends ServiceImpl<ElementMapper, Element> implements ElementService {
    @Override
    public List<Element> getAuthorityElementByUserId(String userId) {
        return null;
    }

    @Override
    public List<Element> getAuthorityElementByUserId(String userId, String menuId) {
        return null;
    }
}
