package com.solvd.laba.bank.worker.operation;

import com.solvd.laba.bank.worker.Worker;

public class Manager extends Worker {
    public Manager(int ID, String fullName) {
        super(ID, fullName);
    }

    @Override
    public boolean isCompAccess() {
        return true;
    }
}
