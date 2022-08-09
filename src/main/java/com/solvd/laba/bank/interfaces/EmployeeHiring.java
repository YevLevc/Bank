package com.solvd.laba.bank.interfaces;

import com.solvd.laba.bank.enums.EmployeePosition;
import com.solvd.laba.bank.worker.Worker;

public interface EmployeeHiring {
    Worker employeeHiring(EmployeePosition position, int ID, String fullName, int salary);
}
