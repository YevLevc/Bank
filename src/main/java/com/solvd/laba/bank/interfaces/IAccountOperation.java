package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.PersonalAccount;

public interface AccountOperation {

    default void withdrawal (PersonalAccount account, double amount) {
        account.setAccountState(account.getAccountState() - amount
                - amount * account.getAccountType().getPercent());
        }
    default void refill (PersonalAccount account, double amount) {
        account.setAccountState(account.getAccountState() + amount
                - amount * account.getAccountType().getPercent());
    }
}
