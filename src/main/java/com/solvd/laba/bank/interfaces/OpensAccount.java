package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.PersonalAccount;
import com.solvd.laba.bank.enums.AccountType;

public interface OpensAccount {
    PersonalAccount openAccount(int clientID, AccountType accountType, double accountState, int pinCode);
}
