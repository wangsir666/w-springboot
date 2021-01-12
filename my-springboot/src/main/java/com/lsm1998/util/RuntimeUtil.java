package com.lsm1998.util;

/**
 * @Auther: wjx
 * @Date: 2020/10/27 16:35
 * @Description:
 */
public class RuntimeUtil {

    public static void execCMD(String cmd){
        try{
            Runtime.getRuntime().exec(cmd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
