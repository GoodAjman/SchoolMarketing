package com.fshare.dao;

//import com.fshare.BaseTest;
import com.fshare.BaseTest;
import com.fshare.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author keny
 * @Date 2019/11/17 0017 上午 11:09
 */

public class AreaDaoTest extends BaseTest {
//快捷键ctrl+shift+T
    @Resource
    private AreaDao areaDao;
    @Test
    public void querArea() {
      List<Area> areaList= areaDao.queryArea();
      assertEquals(2,areaList.size());
    }
}
