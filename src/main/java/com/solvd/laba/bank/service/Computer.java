package com.solvd.laba.bank.service;

import org.apache.commons.lang3.RandomUtils;

public class Computer {
    public static int randomBounds(int from, int to) {
        return (int) (from + Math.abs(Math.random()) * to);
    }

    public static int nextPositiveInt(int bound) {
        return (int) (Math.abs(Math.random()) * bound);
    }

    public static int randomNum() {
        return RandomUtils.nextInt(10, 99);
    }

    public static int randomPin() {
        return RandomUtils.nextInt(100, 999);
    }
}
