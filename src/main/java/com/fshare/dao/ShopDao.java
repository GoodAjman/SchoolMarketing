package com.fshare.dao;

import com.fshare.entity.Shop;

/**
 * @Author keny
 * @Date 2019/11/24 0024 上午 11:13
 */
public interface ShopDao {
    int insertShop(Shop shop);
//    更新店铺
    int updateShop(Shop shop);
}
