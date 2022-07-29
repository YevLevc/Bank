package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.worker.Worker;

public class Security extends Worker {
    private boolean alarmButton = true;

    public Security(int ID, String fullName) {
        super(ID, fullName);
    }

    public boolean isAlarmButton() {
        return alarmButton;
    }

    public void setAlarmButton(boolean alarmButton) {
        this.alarmButton = alarmButton;
    }
}
