package com.fshare.util;

/**
 * @Author keny
 * @Date 2019/11/26 0026 上午 12:05
 */
public class PathUtil {
//    获取系统文件分隔符
    private static String seperator = System.getProperty("fil.seperator");
//返回基础路径
    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image/";
        } else {
            basePath = "/home/ajman/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    // 店铺图片存储子路径
    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
