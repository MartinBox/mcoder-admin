package com.mcoder.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mcoder.admin.constant.CommonConstant;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@KeySequence("SEQ_SYSTEM_ID")
@TableName(value = "tbl_sys_base_menu")
public class Menu extends Model<Menu> {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String code;
    private String title;
    private Integer parentId = CommonConstant.ROOT;
    private String href;
    private String icon;
    private String type;
    private String orderNum;
    private String description;
    private Date crtTime;
    private String crtUser;
    private String crtName;
    private String crtHost;
    private Date updTime;
    private String updUser;
    private String updName;
    private String updHost;
    private String path;
    private List<Menu> subMenu;
}