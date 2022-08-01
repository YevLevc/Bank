package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.worker.Worker;

public class Cashier extends Worker {
    boolean alarmButton = true;

    public Cashier(int ID, String fullName, int salary, int workHours) {
        super(ID, fullName, salary, workHours);
    }

    @Override
    public boolean isCompAccess() {
        return true;
    }

    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }
}
