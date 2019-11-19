package com.fshare.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductImg {
    private Long productImgId;
    private String imgAddr;
    private String imgDesc;
    private Integer priority;
    private Date createTime;
//    属于商品详情页，N对1
    private Long productId;

}
