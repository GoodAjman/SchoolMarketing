package com.fshare.dto;

import com.fshare.entity.Shop;
import com.fshare.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @Author keny
 * @Date 2019/11/30 0030 上午 10:49
 */
//添加店铺返回的数据
@Data
public class ShopExecution {
    private Integer state;//结果状态
    private String stateInfo;//状态标识
    private Integer count;//店铺数量
    private Shop shop;//操作的店铺
    private List<Shop> shopList;//shop列表。查询店铺列表时使用

    public ShopExecution() {

    }

    //    店铺操作成功时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    //    店铺操作失败时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

}
