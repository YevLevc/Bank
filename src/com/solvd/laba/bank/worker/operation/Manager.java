package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.worker.Worker;

public class Manager extends Worker {

    public Manager(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
    }
}
