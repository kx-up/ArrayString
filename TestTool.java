package com.lianxi20210330StringBuffer;

import java.io.UnsupportedEncodingException;

public class TestTool {

    int count = 100000000;
    String abc = "猫咪cats";
    long ms = 0;
    String a;

    public void testArrayString() throws UnsupportedEncodingException {
        ArrayString arrayString = new ArrayString();
        System.out.println("ArrayString");
        ms = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayString.add(abc);
        }
        System.out.println(System.currentTimeMillis() - ms);
    }

    public void testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        System.out.println("StringBuilder");
        ms = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            builder.append(abc);
        }
        System.out.println(System.currentTimeMillis() - ms);
    }

    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("StringBuffer");
        ms = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringBuffer.append(abc);
        }
        System.out.println(System.currentTimeMillis() - ms);
    }

    public void testStringContact() {
        String str = "";
        System.out.println("String.contact");
        ms = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            str.concat(abc);
        }
        System.out.println(System.currentTimeMillis() - ms);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        TestTool testTool = new TestTool();
        testTool.testStringContact();
        testTool.testStringBuilder();
        testTool.testStringBuffer();
        testTool.testArrayString();
    }
}
