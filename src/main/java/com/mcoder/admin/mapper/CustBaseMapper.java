package com.mcoder.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CustBaseMapper<R> extends BaseMapper<R> {
    /**
     * 自定义包装查询接口
     *
     * @param wrapper
     * @return
     */
    R selectByWrapper(@Param("ew") Wrapper wrapper);
}
