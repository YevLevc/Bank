package com.solvd.laba.bank.enums;

public enum EmployeePosition {
    CASHIER ("Cashier"), MANAGER ("Manager");

    private String position;

    EmployeePosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
