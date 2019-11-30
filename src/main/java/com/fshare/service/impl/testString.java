package com.fshare.service.impl;

import com.fshare.entity.Area;
import com.fshare.entity.Shop;

/**
 * @Author keny
 * @Date 2019/11/30 0030 下午 2:45
 */
public class testString {
    public void cc(Area aa){
        aa.setAreaId(1234);
    }


    public static void main(String[] args) {
        Area area=new Area();
        area.setAreaId(111);
        testString testString=new testString();
        testString.cc(area);
        System.out.println(area.getAreaId());
    }
}
