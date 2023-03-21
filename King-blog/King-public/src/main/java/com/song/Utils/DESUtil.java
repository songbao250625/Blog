package com.song.Utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * 密码加密解密工具
 * 1.修改启动类为：
 *@org.springframework.boot.autoconfigure.SpringBootApplication
 * @MapperScan("com.song.Dao")
 * public class blogRunApp {
 *     public static void main(String[] args) {
 *         ApplicationContext ac = SpringApplication.run(blogRunApp.class, args);
 *         System.out.println("项目启动成功！！！！！！");
 *     }
 * }
 * 2.配置文件修改如下：
 * # 密码加密
 * des:
 *   password: 80c656508072974d
 *   3.调用方法：String password = user.getPassword();
 *         password = DESUtil.encrypt(password,DESUtil.KEY);
 *         log.info("加密后的密码"+password);
 *         user.setPassword(password);
 */
public class DESUtil {

    public static final String KEY_DES = "DES";
    public static final String KEY = "TY5YIGWFMWK3MOW4Y45KRWW382X3U8NI";


    public static String encrypt(String text, String key) {
        try {
            return byte2hex(encrypt(text.getBytes("UTF8"), key.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("加密[" + text + "]发生异常:" + e.getMessage(), e);
        }
    }

    public static String decrypt(String text, String key) {
        try {
            return new String(decrypt(hex2byte(text.getBytes("UTF8")), key.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("解密[" + text + "]发生异常:" + e.getMessage(), e);
        }
    }


    private static byte[] encrypt(byte[] data, byte[] key) {
        byte[] bytes = null;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(KEY_DES);
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(key)), new SecureRandom());
            bytes = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static byte[] decrypt(byte[] data, byte[] key) {
        byte[] bytes = null;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(KEY_DES);
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(key)), new SecureRandom());
            bytes = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }
}