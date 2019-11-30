package com.fshare.service;

import com.fshare.dto.ShopExecution;
import com.fshare.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @Author keny
 * @Date 2019/11/30 0030 下午 2:19
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

}
