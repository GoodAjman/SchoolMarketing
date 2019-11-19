package com.fshare.entity;

import lombok.Data;

import java.util.Date;
@Data
public class ShopCategory {
//    商铺类别
    private Long shopCategoryId;

    private String shopCategoryName;
    private String shopCategoryDesc;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
//    上级ID
    private ShopCategory parent;

}
