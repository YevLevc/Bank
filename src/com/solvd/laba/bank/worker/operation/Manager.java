package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.Client;
import com.solvd.laba.bank.Enums.AccountType;
import com.solvd.laba.bank.accounts.PersonalAccount;
import com.solvd.laba.bank.worker.Worker;

public class Manager extends Worker implements OpensAccount{

    public Manager(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
    }

    @Override
    public PersonalAccount openAccount(int clientID, AccountType accountType, double accountState, int pinCode) {
        return new PersonalAccount(clientID,accountType,accountState,pinCode);
    }
}
