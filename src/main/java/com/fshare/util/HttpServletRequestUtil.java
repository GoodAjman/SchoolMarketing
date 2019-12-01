package com.fshare.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author keny
 * @Date 2019/12/1 0001 上午 10:48
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key));
        } catch (NumberFormatException e) {
           return -1;
        }
    }



    public static long getLong(HttpServletRequest request,String key){
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1l;
        }
    }
    public static Double getDouble(HttpServletRequest request,String key){
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1d;
        }
    }
    public static boolean getBoolean(HttpServletRequest request,String key){
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String getString(HttpServletRequest request, String name) {
        try {
            String result = request.getParameter(name);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result))
                result = null;
            return result;
        } catch (Exception e) {
            return null;
        }

    }
}
