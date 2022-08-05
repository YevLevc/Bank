package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Sysadmin extends Worker {
    public Sysadmin(int ID, String fullName, int salary) {
        super(ID, fullName, salary);
    }

    @Override
    public void setCompAccess(boolean compAccess) {
        super.setCompAccess(true);
    }
}
