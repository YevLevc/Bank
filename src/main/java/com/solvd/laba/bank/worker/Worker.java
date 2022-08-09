package com.solvd.laba.bank.worker;

import com.solvd.laba.bank.Person;

public abstract class Worker extends Person {
    private int salary;
    boolean safeAccess;
    boolean cashregAccess;

    public Worker(int ID, String fullName, int salary) {
        super(ID, fullName);
        this.salary = salary;
    }

    public Worker() {
    }

    public boolean isSafeAccess() {
        return safeAccess;
    }

    public boolean isCashregAccess() {
        return cashregAccess;
    }

    public void setSafeAccess(boolean safeAccess) {
        this.safeAccess = safeAccess;
    }

    public void setCashregAccess(boolean cashregAccess) {
        this.cashregAccess = cashregAccess;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
