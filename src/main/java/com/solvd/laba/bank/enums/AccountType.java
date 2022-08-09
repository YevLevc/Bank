package com.solvd.laba.bank.enums;

public enum AccountType {
    CARD(0.005), DEPOSIT(0.10), CREDIT(0.17);
    private double percent;

    AccountType(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}

