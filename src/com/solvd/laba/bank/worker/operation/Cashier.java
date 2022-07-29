package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.worker.Worker;

public class Cashier extends Worker {
    boolean alarmButton = true;

    public Cashier(int ID, String fullName) {
        super(ID, fullName);
    }

    @Override
    public boolean isCompAccess() {
        return true;
    }

    @Override
    public boolean isCashregAccess() {
        return true;
    }
}
