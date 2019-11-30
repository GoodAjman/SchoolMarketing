package com.fshare.service.impl;

import com.fshare.dao.AreaDao;
import com.fshare.entity.Area;
import com.fshare.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author keny
 * @Date 2019/11/22 0022 下午 10:16
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
