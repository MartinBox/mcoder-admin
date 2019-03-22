package com.mcoder.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@KeySequence("SEQ_SYSTEM_ID")
@TableName(value = "tbl_sys_base_element")
public class Element extends Model<Element> {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String code;
    private String type;
    private String name;
    private String uri;
    private String menuId;
    private String parentId;
    private String path;
    private String method;
    private String description;
    private Date crtTime;
    private String crtUser;
    private String crtName;
    private String crtHost;
}