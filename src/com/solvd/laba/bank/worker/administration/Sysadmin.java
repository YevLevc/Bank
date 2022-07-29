package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Sysadmin extends Worker {
    @Override
    public boolean isCompAccess() {
        return true;
    }
}
