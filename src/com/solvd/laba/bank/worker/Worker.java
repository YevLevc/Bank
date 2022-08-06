package com.solvd.laba.bank.worker;

import com.solvd.laba.bank.Person;

public abstract class Worker extends Person {
    private int salary;
    boolean safeAccess;
    boolean compAccess;
    boolean cashregAccess;

    public Worker(int ID, String fullName, int salary) {
        super(ID, fullName);
        this.salary = salary;
    }

    public Worker() {
        super();
    }

    public boolean isSafeAccess() {
        return safeAccess;
    }

    public boolean isCompAccess() {
        return compAccess;
    }

    public boolean isCashregAccess() {
        return cashregAccess;
    }

    public void setSafeAccess(boolean safeAccess) {
        this.safeAccess = safeAccess;
    }

    public void setCompAccess(boolean compAccess) {
        this.compAccess = compAccess;
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
