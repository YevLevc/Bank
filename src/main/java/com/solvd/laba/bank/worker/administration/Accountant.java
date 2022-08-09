package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Accountant extends Worker {
    private boolean alarmButton = true;

    public Accountant(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }

    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

}
