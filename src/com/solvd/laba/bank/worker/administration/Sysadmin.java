package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Sysadmin extends Worker {
    public Sysadmin(int ID, String fullName) {
        super(ID, fullName);
    }

    @Override
    public boolean isCompAccess() {
        return true;
    }
}
