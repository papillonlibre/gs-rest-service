package com.my_implementation;

import java.util.ArrayList; 
import java.util.List; 

public class Employees {
    private List<Employee> employeeList;
    
    public Employees() {
        this.employeeList = new ArrayList<>();
    }
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

}
