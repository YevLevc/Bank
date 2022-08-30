package com.solvd.laba.bank.worker;

import com.solvd.laba.bank.Person;

public class Worker <T> extends Person {
    private int salary;
    boolean safeAccess;
    boolean cashregAccess;
    private T position;

    public Worker(int ID, String fullName, T position, int salary) {
        super(ID, fullName);
        this.salary = salary;
        this.safeAccess = safeAccess;
        this.cashregAccess = cashregAccess;
        this.position = position;
    }

    public Worker() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isSafeAccess() {
        return safeAccess;
    }

    public void setSafeAccess(boolean safeAccess) {
        this.safeAccess = safeAccess;
    }

    public boolean isCashregAccess() {
        return cashregAccess;
    }

    public void setCashregAccess(boolean cashregAccess) {
        this.cashregAccess = cashregAccess;
    }

    public T getPosition() {
        return position;
    }

    public void setPosition(T position) {
        this.position = position;
    }

}
