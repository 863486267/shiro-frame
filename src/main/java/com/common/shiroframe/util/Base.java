package com.common.shiroframe.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base {

    public static   String md5Hash(String string) {
        try {
            StringBuilder sb = new StringBuilder();
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest =md5.digest(string.getBytes("utf8"));
            for (byte b : digest) {
                //把每个字节转换成16进制数
                int d = b & 0xff;//0x00 00 00 00 ff
                String hexString = Integer.toHexString(d);
                if(hexString.length() == 1){
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
