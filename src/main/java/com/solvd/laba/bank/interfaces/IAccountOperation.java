package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.enums.AccountType;
import com.solvd.laba.bank.exeptions.BalanceException;

public interface IAccountOperation {

    default void withdrawal(PersonalAccount account, double amount) {
        if (account.getAccountState() < amount + amount * account.getAccountType().getPercent()
                || account.getAccountType() == AccountType.CARD) throw new BalanceException();
        else account.setAccountState(account.getAccountState() - amount
                - amount * account.getAccountType().getPercent());
    }

    default void refill(PersonalAccount account, double amount) {
        account.setAccountState(account.getAccountState() + amount
                - amount * account.getAccountType().getPercent());
    }
}
