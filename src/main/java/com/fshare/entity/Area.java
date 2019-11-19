package com.fshare.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Area {
    private Integer areaId;

    private String areaName;

    private String priority;

    private Date createtime;

    private Date lastEditTime;

}
