package com.ldujsjxh.utils;

import java.util.Random;

/**
 * @author ZYR
 * @date 11/12/2019 10:23 PM
 * Description: 生成随机的6位验证码
 */
public class VeriCodeUtil {
    public static String getVeriCode(){
        String str="0123456789";
        StringBuilder veriCode=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            veriCode.append(ch);
    }
        return veriCode.toString();
    }

}
