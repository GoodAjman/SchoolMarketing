package com.fshare.entity;

import lombok.Data;

import java.util.Date;
@Data
public class ProductCategory {
//    商品类别
    private Long productCategory;
    private Long shopId;
    private String productCategotyName;
    private Integer priority;
    private Date createTime;

}
