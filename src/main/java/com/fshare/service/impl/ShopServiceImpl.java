package com.fshare.service.impl;

import com.fshare.dao.ShopDao;
import com.fshare.dto.ShopExecution;
import com.fshare.entity.Shop;
import com.fshare.enums.ShopStateEnum;
import com.fshare.exceptions.ShopOperationException;
import com.fshare.service.ShopService;
import com.fshare.util.PathUtil;
import com.fshare.util.ImageUtil;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.Date;

/**
 * @Author keny
 * @Date 2019/11/30 0030 下午 2:22
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
//        检查参数
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
//        还需要对shop中的区域或者店铺信息进行判断非空
        try {
//            给店铺信息赋值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
//            添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if (effectNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            }else {
                if(shopImgInputStream !=null){
//                    存储图片
                    try {
//                        存储图片，并改变shop中的值
                        addShopImg(shop, shopImgInputStream,fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error"+e.getMessage());
                    }
//                    shop.getShopImg();
//                    更新店铺的图片地址
                    effectNum=shopDao.updateShop(shop);
                    if(effectNum<=0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
//        获取shop图片目录的相对值路径
        String dest= PathUtil.getShopImagePath(shop.getShopId());
//        再生成随机名
        String shopImgAddr= ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
