package top.jif12138.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式： 时间+随机数
     *synchronized 多线程相关
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();

        System.currentTimeMillis();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
