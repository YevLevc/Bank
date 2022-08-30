package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.interfaces.IAccountOperation;
import com.solvd.laba.bank.worker.Worker;

public class Cashier extends Worker implements IAccountOperation {
    boolean alarmButton = true;

    public Cashier(int ID, String fullName, Object position, int salary) {
        super(ID, fullName, position, salary);
    }

    public Cashier() {
    }

    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }

}