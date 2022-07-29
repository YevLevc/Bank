package com.solvd.laba.bank.worker;

public abstract class Worker {
    private int ID;
    private String fullName;
    private int salary;
    private int workHours;

    boolean safeAccess;
    boolean compAccess;
    boolean cashregAccess;

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
