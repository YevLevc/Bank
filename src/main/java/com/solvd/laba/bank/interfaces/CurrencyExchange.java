package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.enums.Currency;

public interface CurrencyExchange {
    public default double changeCurrency(double income, Currency a, Currency b) {
       return income / a.getRate() * b.getRate();
    }
}