package com.fshare.serviceTest;

import com.fshare.BaseTest;
import com.fshare.entity.Area;
import com.fshare.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Author keny
 * @Date 2019/11/22 0022 下午 10:20
 */

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void areaServiceTest(){
       List<Area> resultlist=areaService.getAreaList();
       assertEquals("广州",resultlist.get(0).getAreaName());
    }
}
