package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.enums.Currency;

public interface CurrencyExchange {
    double changeCurrency(double income, Currency a, Currency b);
}
