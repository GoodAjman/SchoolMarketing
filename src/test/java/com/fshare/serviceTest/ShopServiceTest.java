package com.fshare.serviceTest;

import com.fshare.BaseTest;
import com.fshare.dto.ShopExecution;
import com.fshare.entity.Area;
import com.fshare.entity.PersonInfo;
import com.fshare.entity.Shop;
import com.fshare.entity.ShopCategory;
import com.fshare.enums.ShopStateEnum;
import com.fshare.exceptions.ShopOperationException;
import com.fshare.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @Author keny
 * @Date 2019/11/30 0030 下午 10:19
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setShopCategory(shopCategory);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopName("测试店铺1");
        shop.setPhone("testphone");
        shop.setShopDesc("test1");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        shop.setShopAddr("testAddr1");
        shop.setPriority(1);
//        CommonsMultipartFile shopImg=new CommonsMultipartFile("E:/image/card.jpg");
        File shopImg = new File("E:/image/card.jpg");
        InputStream is = new FileInputStream(shopImg);
//        stream是不能使用getname的方法获取名字的
        ShopExecution shopExecution = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());

    }


}
