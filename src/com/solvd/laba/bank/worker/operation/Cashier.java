package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.Enums.AccountType;
import com.solvd.laba.bank.Enums.Currency;
import com.solvd.laba.bank.accounts.PersonalAccount;
import com.solvd.laba.bank.worker.Worker;

public class Cashier extends Worker {
    boolean alarmButton = true;

    public Cashier() {
        super();
    }

    public Cashier(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
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

    public void accountOperation(PersonalAccount account, double income) {
        if (isCashregAccess()) {
            account.setAccountState(account.getAccountState() + income -
                    Math.abs(income*account.getAccountType().getPercent()));
        }
    }
}