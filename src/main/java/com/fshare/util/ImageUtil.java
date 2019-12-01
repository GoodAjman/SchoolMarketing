package com.fshare.util;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author keny
 * @Date 2019/11/24 0024 下午 10:40
 */
public class ImageUtil {
   static String basePath= Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName,String targetAddr){
//        图片的随机名
        String readFileName = getRandomFileName();
//        扩展名
        String extension = getFileExtension(fileName);
//        创建路径
        makeDirPath(targetAddr);
//        相对路径及名字
        String relativeAddr = targetAddr + readFileName + extension;

        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            System.out.println("basepath"+basePath);
            Thumbnails.of(thumbnailInputStream).size(200, 200).
                    watermark(Positions.BOTTOM_CENTER, ImageIO.read(new File(basePath + "year.png")), 0.25f).
                    outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;

    }
/**
 * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
 */
    public static String getRandomFileName() {
        Integer ranNum = r.nextInt(89999) + 10000;    //10000 - 99999
        String currentTime = simpleDateFormat.format(new Date());
        return currentTime + ranNum;

    }
//获取扩展名
    private static String getFileExtension(String fileName) {
//        获取文件流的文件名
        return fileName.substring(fileName.lastIndexOf("."));
    }
//创建文件夹
    private static void makeDirPath(String targetAddr) {
        String realFilePath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFilePath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }


    public static void main(String[] args) {
        String basePath= Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("basepath"+basePath);
//        String basePath = "E:/image/";
        try {
            Thumbnails.of(new File("E:/image/card.jpg")).size(200, 200).
                    watermark(Positions.CENTER_LEFT, ImageIO.read(new File(basePath + "year.png")), 0.25f).outputQuality(0.8f).toFile("E:/image/cardnew.jpg");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
