package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Accountant extends Worker {
    private boolean alarmButton = true;

    public Accountant(int ID, String fullName, int salary, int workHours) {
        super(ID, fullName, salary, workHours);
    }


    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
    }
}
