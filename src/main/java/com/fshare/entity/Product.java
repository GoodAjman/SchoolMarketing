package com.fshare.entity;

import java.util.Date;
import java.util.List;

/**
 * @Author keny
 * @Date 2019/11/16 0016 下午 8:19
 */
public class Product {
    private static final long serialVersionUID = -349433539553804024L;
    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;// 简略图
    private String normalPrice;
//    折扣价
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
//    0 下架 1 在前端页面展示系统存在
    private Integer enableStatus;
    private Integer point;
//商品详情页图片列表
    private List<ProductImg> productImgList;
// 商品类别
    private ProductCategory productCategory;
//    属于哪个店铺
    private Shop shop;
}
