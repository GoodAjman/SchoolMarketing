package com.fshare.enums;

import lombok.Data;

/**
 * @Author keny
 * @Date 2019/11/30 0030 上午 10:54
 */
public enum ShopStateEnum {
    CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"), INNER_ERROR(-1001, "操作失败"), NULL_SHOPID(-1002, "ShopId为空"),
    NULL_SHOP_INFO(-1003, "传入了空的信息");
    private Integer state;
    private String stateInfo;

    private ShopStateEnum(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum getStateEnum(int index) {
        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.getState() == index) {
                return stateEnum;
            }
        }

        return null;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
