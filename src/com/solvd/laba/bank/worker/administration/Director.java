package com.solvd.laba.bank.worker.administration;

import com.solvd.laba.bank.worker.Worker;

public class Director extends Worker {
    private boolean alarmButton = true;
    @Override
    public boolean isSafeAccess() {
        return true;
    }

    @Override
    public boolean isCashregAccess() {
        return true;
    }

    @Override
    public boolean isCompAccess() {
        return true;
    }
}