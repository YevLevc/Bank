package com.solvd.laba.bank.accounts;

public class PersonalAccount {
    private int accountNumber;
    private int accountState;

    public PersonalAccount(int accountNumber, int accountState) {
        this.accountNumber = accountNumber;
        this.accountState = accountState;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountState() {
        return accountState;
    }

    public void setAccountState(int accountState) {
        this.accountState = accountState;
    }
}
