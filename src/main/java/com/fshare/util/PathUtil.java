package com.fshare.util;

/**
 * @Author keny
 * @Date 2019/11/26 0026 上午 12:05
 */
public class PathUtil {
    //    获取系统文件分隔符
//    private static String seperator = System.getProperty("file.seperator");
    private static String seperator = System.getProperty("file.separator");
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
//        String imagePath = "upload/item/shop/" + shopId + "/";
        StringBuilder shopImagePathBuilder = new StringBuilder();
        shopImagePathBuilder.append("upload/item/shop/");
        shopImagePathBuilder.append(shopId);
        shopImagePathBuilder.append("/");
        String shopImagePath = shopImagePathBuilder.toString().replace("/", seperator);
        return shopImagePath;

    }
}
