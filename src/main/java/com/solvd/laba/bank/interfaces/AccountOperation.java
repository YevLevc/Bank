package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.PersonalAccount;

public interface AccountOperation {

    default double withdrawal (PersonalAccount account, double amount) {
         return account.getAccountState() - amount - amount*account.getAccountType().getPercent();
        }
    default double refill (PersonalAccount account, double amount) {
        return account.getAccountState() + amount - amount*account.getAccountType().getPercent();
    }
}
