package com.solvd.laba.bank;

import com.solvd.laba.bank.accounts.PersonalAccount;

public class Client extends Person {
    private PersonalAccount accNumber;
    private int managerID;

    public Client(int ID, String fullName, PersonalAccount accNumber, int managerID) {
        super(ID, fullName);
        this.accNumber = accNumber;
        this.managerID = managerID;
    }

    public Client(int ID, String fullName) {
        super(ID, fullName);
    }

    public PersonalAccount getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(PersonalAccount accNumber) {
        this.accNumber = accNumber;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
