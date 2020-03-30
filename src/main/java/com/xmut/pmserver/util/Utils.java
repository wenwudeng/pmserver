package com.xmut.pmserver.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils extends UtilsBaseData{
    /**
     * 生成注册日期
     * @return
     */
    public static String getRegisterDate() {
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
}
