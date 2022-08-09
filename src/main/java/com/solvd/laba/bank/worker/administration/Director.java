package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.enums.EmployeePosition;
import com.solvd.laba.bank.interfaces.EmployeeHiring;
import com.solvd.laba.bank.worker.Worker;
import com.solvd.laba.bank.worker.operation.Cashier;
import com.solvd.laba.bank.worker.operation.Manager;

public class Director extends Worker implements EmployeeHiring {
    private boolean alarmButton = true;

    public Director(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }


    @Override
    public void setSafeAccess(boolean safeAccess) {
        super.setSafeAccess(true);
    }

    @Override
    public void setCashregAccess(boolean cashregAccess) {
        super.setCashregAccess(true);
    }

    public Worker employeeHiring (EmployeePosition position, int ID, String fullName, int salary){
        if (position==EmployeePosition.MANAGER) return new Manager (ID, fullName, salary);
        if (position==EmployeePosition.CASHIER) return new Cashier(ID, fullName, salary);
        return null;
    }
}