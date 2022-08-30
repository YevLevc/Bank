package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Accountant extends Worker {
    private boolean alarmButton = true;

    public Accountant(int ID, String fullName, Object position, int salary, boolean alarmButton) {
        super(ID, fullName, position, salary);
    }

    public Accountant(boolean alarmButton) {
        this.alarmButton = alarmButton;
    }

    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

}
