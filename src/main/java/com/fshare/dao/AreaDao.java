package com.fshare.dao;

import com.fshare.entity.Area;

import java.util.List;

/**
 * @Author keny
 * @Date 2019/11/17 0017 上午 10:40
 */
public interface AreaDao {
    /*
    列出area的返回列表
    *
    */
    List<Area> queryArea();

}
