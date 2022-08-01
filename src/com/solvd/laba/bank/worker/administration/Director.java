package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Director extends Worker {
    private boolean alarmButton = true;

    public Director(int ID, String fullName, int salary, int workHours) {
        super(ID, fullName, salary, workHours);
    }


    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
    }
}