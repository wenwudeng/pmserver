package com.xmut.pmserver.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils extends UtilsBaseData{
    /**
     * 生成注册日期
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
        return sdf.format(date);
    }

    /**
     * 生成随机昵称
     *
     * @return
     */
    public static String generateName() {
        int adjLen= adjective.length;
        int nLen= noun.length;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        sb.append(adjective[random.nextInt(adjLen)]);
        sb.append(noun[random.nextInt(nLen)]);
        return sb.toString();
    }


    /**
     * @param text 明文
     * @param key  密钥
     * @return 密文
     */

    // 带秘钥加密
    public static String md5(String text, String key) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text + key);
     //   System.out.println("MD5加密后的字符串为:" + md5str);
        return md5str;
    }

    // 不带秘钥加密
    public static String md52(String text) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text);
        System.out.println("MD52加密后的字符串为:" + md5str + "\t长度：" + md5str.length());
        return md5str;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  MD5密文
     */
    // 根据传入的密钥进行验证
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }
}
