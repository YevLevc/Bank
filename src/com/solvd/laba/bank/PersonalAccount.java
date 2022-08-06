package com.solvd.laba.bank.accounts;

import com.solvd.laba.bank.enums.AccountType;

public class PersonalAccount {
    private int clientID;
    private AccountType accountType;
    private double accountState;
    private int pinCode;



    public PersonalAccount(int clientID, AccountType accountType, double accountState, int pinCode) {
        this.clientID = clientID;
        this.accountType = accountType;
        this.accountState = accountState;
        this.pinCode = pinCode;
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

    public int getPinCode() {
        return pinCode;
    }
}