package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.Enums.AccountType;
import com.solvd.laba.bank.accounts.PersonalAccount;

public interface OpensAccount {
    PersonalAccount openAccount(int clientID, AccountType accountType, double accountState, int pinCode);
}
