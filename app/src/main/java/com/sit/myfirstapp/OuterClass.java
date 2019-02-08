package com.sit.myfirstapp;

public class OuterClass {

    private static int i;
    private int j;

    public static class Builder {
        public static final int t = i;
    }

    public class Builder2 {
        public int y = j;

    }

}