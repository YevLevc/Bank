package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.enums.Currency;
import com.solvd.laba.bank.interfaces.*;
import com.solvd.laba.bank.worker.Worker;

public class Cashier extends Worker implements CurrencyExchange, AccountOperation {
    boolean alarmButton = true;

    public Cashier() {

    }

    public Cashier(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }


    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }


    public double changeCurrency(double income, Currency a, Currency b) {
        if (isCashregAccess()) {
            return income / a.getRate() * b.getRate();
        }
        return 0;
    }
}