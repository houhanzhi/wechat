package com.imooc.sell.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * 注意：在高并发的情况下生成的主键容易重复，所以加synchronized关键字
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        //生成6为随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
