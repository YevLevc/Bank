package com.solvd.laba.bank.enums;

public enum Currency {
    UAH(1), USD(0.028), EUR(0.025), PLN(0.15);
    private double rate;


    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
