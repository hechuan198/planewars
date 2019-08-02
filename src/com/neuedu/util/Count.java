package com.neuedu.util;

public class Count {
    private static int count;

    public static void setCount(int a) {
        count  += a;
    }

    public static int getCount() {
        return count;
    }
}
