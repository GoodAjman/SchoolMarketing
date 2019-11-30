package com.fshare.exceptions;

/**
 * @Author keny
 * @Date 2019/11/30 0030 下午 4:10
 */
public class ShopOperationException extends RuntimeException {
    private static final long serialVersionUID = 872257425898301796L;
    public ShopOperationException(String msg) {
        super(msg);
    }
}
