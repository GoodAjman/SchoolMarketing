package com.fshare.dao;

import com.fshare.BaseTest;
import com.fshare.entity.Area;
import com.fshare.entity.PersonInfo;
import com.fshare.entity.Shop;
import com.fshare.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @Author keny
 * @Date 2019/11/24 0024 下午 1:06
 */
public class ShopTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testinsertShop(){
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);

        shop.setShopCategory(shopCategory);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopName("测试店铺");
        shop.setPhone("testphone");
        shop.setShopDesc("test");
        shop.setEnableStatus(1);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");
        shop.setShopAddr("testAddr");
        shop.setShopImg("testimg");
        shop.setPriority(1);

        int effectNum=shopDao.insertShop(shop);
        assertEquals(effectNum,1);

    }
    @Test
    public void testUpdateShop(){
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setPriority(2);
        shop.setShopName("updateShopName");
//        effectNum
        int effectNum=shopDao.updateShop(shop);
        assertEquals(1,effectNum);
    }

}
