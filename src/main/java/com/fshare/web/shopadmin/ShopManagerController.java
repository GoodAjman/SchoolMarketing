package com.fshare.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fshare.dto.ShopExecution;
import com.fshare.entity.PersonInfo;
import com.fshare.entity.Shop;
import com.fshare.enums.ShopStateEnum;
import com.fshare.service.ShopService;
import com.fshare.util.HttpServletRequestUtil;
import com.fshare.util.ImageUtil;
import com.fshare.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author keny
 * @Date 2019/12/1 0001 上午 10:43
 */
@Controller
@RequestMapping("/shopadmin")

public class ShopManagerController {
    @Autowired
    private ShopService shopService;
    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String,Object>();
//       接收并转化相应的参数，包括店铺信息以及图片信息
        String shopStr= HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper=new ObjectMapper();
        Shop shop=null;
        try{
            shop=mapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errmsg",e.getMessage());
            return modelMap;
        }
//        todo:去看一下springmvc中的CommonsMultiPartFile
        CommonsMultipartFile shopImg=null;
//        判断是否有上传的文件流,文件解析器
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
//        如果有文件流
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
//            获取文件流
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
//        注册店铺
        if(shop!=null&&shopImg!=null){
//            Session TODO
            PersonInfo owner=new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution se= null;
            try {
                se = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                if(se.getState()== ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);
                }else{
                    modelMap.put("success",false);
                    modelMap.put("errmsg",se.getStateInfo());

                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errmsg",se.getStateInfo());
            }

            return modelMap;
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
//        返回结果
    }

}
