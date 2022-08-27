package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.worker.Worker;

public interface EmployeeHiring {
    <T> Worker employeeHiring (int ID, String fullName, T position, int salary);
}
