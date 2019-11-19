package com.fshare.entity;

import lombok.Data;

import java.util.Date;
@Data
public class localhostAuth {
    private Long localAuthId;
    private String username;
    private String password;
    private Date createTime;
    private Date lastEditIme;
    private PersonInfo personInfo;

}
