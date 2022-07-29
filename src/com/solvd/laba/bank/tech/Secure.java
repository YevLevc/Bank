package com.solvd.laba.bank.tech;

public abstract class Secure extends Device {
    private int password;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
