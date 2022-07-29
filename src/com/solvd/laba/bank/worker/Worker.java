package com.solvd.laba.bank.worker;

import com.solvd.laba.bank.Person;

public abstract class Worker extends Person {
    private int salary;
    private int workHours;

    boolean safeAccess;
    boolean compAccess;
    boolean cashregAccess;

    public Worker(int ID, String fullName) {
        super(ID, fullName);
    }

    public boolean isSafeAccess() {
        return safeAccess;
    }

    public void setSafeAccess(boolean safeAccess) {
        this.safeAccess = safeAccess;
    }

    public boolean isCompAccess() {
        return compAccess;
    }

    public void setCompAccess(boolean compAccess) {
        this.compAccess = compAccess;
    }

    public boolean isCashregAccess() {
        return cashregAccess;
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

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

}
