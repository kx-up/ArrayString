package com.lianxi20210330StringBuffer;

public class Test {

    public static void main(String[] args) {
        int count = 10000;
        String str = "";
        long ms = 0;

        ms = System.currentTimeMillis(); // 获取当前时间的时间戳
        for (int i = 0; i < 100000; i++) {
            str += "abc";
        }
        System.out.println(System.currentTimeMillis() - ms); // 计算运行循环所花的毫秒数
    }
}