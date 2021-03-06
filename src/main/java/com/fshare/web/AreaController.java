package com.fshare.web;

import com.fshare.entity.Area;
import com.fshare.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author keny
 * @Date 2019/11/22 0022 下午 11:01
 */
@Controller
@RequestMapping("/superadmin")
//@Slf4j
public class AreaController {
   Logger logger= LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("===start===");
        long startTime=System.currentTimeMillis();
        List<Area> list = new ArrayList<Area>();
        try {
            list=areaService.getAreaList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        logger.error("test error");
        long endTime=System.currentTimeMillis();
        logger.debug("costTime{} ms",endTime-startTime);
        logger.info("===end===");
    return modelMap;
    }
}
