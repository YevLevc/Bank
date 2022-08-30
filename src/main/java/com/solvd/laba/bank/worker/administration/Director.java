package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.interfaces.IEmployeeHiring;
import com.solvd.laba.bank.worker.Worker;

public class Director extends Worker implements IEmployeeHiring {
    private boolean alarmButton = true;

    public Director(int ID, String fullName, Object position, int salary, boolean alarmButton) {
        super(ID, fullName, position, salary);
        this.alarmButton = alarmButton;
    }

    public Director() {
    }

    public boolean isAlarmButton() {
        return alarmButton;
    }

    public void setAlarmButton(boolean alarmButton) {
        this.alarmButton = alarmButton;
    }

    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }

    public <T> Worker employeeHiring (int ID, String fullName, T position, int salary){

        return new  <T> Worker (ID, fullName, position, salary);
    }
}