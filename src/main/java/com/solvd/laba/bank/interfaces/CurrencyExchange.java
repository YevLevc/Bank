package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.enums.Currency;

public interface ICurrencyExchange {
    public default double changeCurrency(double income, Currency a, Currency b) {
    }
}
