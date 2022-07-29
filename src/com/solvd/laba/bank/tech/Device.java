package com.solvd.laba.bank.tech;

public abstract class Device {
    private int IN;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIN() {
        return IN;
    }

    public void setIN(int IN) {
        this.IN = IN;
    }
}
