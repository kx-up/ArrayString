package com.lianxi20210330StringBuffer;

import java.io.UnsupportedEncodingException;

public class ArrayString {

    private final int ADD_SIZE = 100000000; // 增加值

    private byte[] value = new byte[ADD_SIZE];

    private String coder = "UTF-8";

    public int maxSize = ADD_SIZE; // 最大长度
    private int p = 0; // 指针、当前大小

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public void add(String str) throws UnsupportedEncodingException {
        if (str == null) { // 传入null抛出异常
            throw new NullPointerException();
        }

        byte[] bytes = str.getBytes(coder);

        if(bytes.length <= 0) {
            return;
        }

        if ((p + bytes.length ) > maxSize) { // value不够存则扩容
            maxSize += ADD_SIZE;
            byte[] newValue = new byte[maxSize];
            System.arraycopy(value, 0, newValue, 0, p);
            this.value = newValue;
        }

        System.arraycopy(bytes, 0, this.value, p, bytes.length);
        p += bytes.length;
    }

    public String toString() {
        byte[] bytes = new byte[p];
        System.arraycopy(value, 0, bytes, 0, p);
        String str = "";

        try {
            str = new String(bytes, coder);
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return str;
    }

    public void show() {
        System.out.println("value.length " + value.length);
        System.out.println("maxSize " + maxSize);
        System.out.println("p " + p);
    }

    public static void main(String[] args) {
        int count = 100000000;
        String abc = "猫咪cats";
        long ms = 0;
        String a;

        ArrayString arrayString = new ArrayString();
        System.out.println("ArrayString");
        ms = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
//            arrayString.add(abc);
        }
        System.out.println(System.currentTimeMillis() - ms);
    }
}