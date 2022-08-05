package com.solvd.laba.bank.accounts;

import com.solvd.laba.bank.Enums.AccountType;

public class PersonalAccount {
    private int clientID;
    private AccountType accountType;
    private double accountState;
    private int pin;



    public PersonalAccount(int clientID, AccountType accountType, double accountState, int pin) {
        this.clientID = clientID;
        this.accountType = accountType;
        this.accountState = accountState;
        this.pin = pin;
    }

    public int getClientID() {
        return clientID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getAccountState() {
        return accountState;
    }

    public void setAccountState(double accountState) {
        this.accountState = accountState;
    }

    public int getPin() {
        return pin;
    }
}
