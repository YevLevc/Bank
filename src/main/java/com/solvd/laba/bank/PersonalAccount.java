package com.solvd.laba.bank;

import com.solvd.laba.bank.enums.AccountType;
import com.solvd.laba.bank.exeptions.BalanceException;
import org.apache.log4j.Logger;

public class PersonalAccount {
    private static final Logger LOGGER = Logger.getLogger(PersonalAccount.class);
    private int accountNumber;
    private AccountType accountType;
    private double accountState;
    private int pinCode;

    private boolean accountBlocked;

    public boolean isAccountBlocked() {
        return accountBlocked;
    }

    public void setAccountBlocked(boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    public PersonalAccount(int accountNumber, AccountType accountType, double accountState, int pinCode) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountState = accountState;
        this.pinCode = pinCode;
    }
    public PersonalAccount(int accountNumber, AccountType accountType, double accountState, boolean isBlocked, int pinCode) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountState = accountState;
        this.accountBlocked = isBlocked;
        this.pinCode = pinCode;
    }

    public int getAccountNumber() {
        return accountNumber;
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
        if (accountType.equals(AccountType.CARD) && accountState < 0) {
            try {
                throw new BalanceException("Insufficient funds");
            } catch (BalanceException e) {
                LOGGER.info(e.getMessage());
            }
        }
        this.accountState = accountState;
    }

    public int getPinCode() {
        return pinCode;
    }


    public String infoString() {
        return "Number: " + this.accountNumber + " | Type: " + this.accountType +
                " | State: " + this.accountState + " | Blocked: " + this.isAccountBlocked() + " | " + this.pinCode;
    }
    @Override
    public String toString() {
        return this.accountNumber + ", " + this.accountType +
                ", " + this.accountState + ", " + this.isAccountBlocked() + ", " + this.pinCode;
    }
}
