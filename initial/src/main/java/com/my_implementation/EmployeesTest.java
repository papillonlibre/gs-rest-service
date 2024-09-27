package com.my_implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeesTest {

    private Employees employees;

    @BeforeEach
    public void setUp() {
        employees = new Employees();
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
        employees.addEmployee(employee);

        List<Employee> employeeList = employees.getEmployeeList();
        assertEquals(1, employeeList.size());
        assertEquals("1", employeeList.get(0).getEmployeeId());
        assertEquals("John", employeeList.get(0).getFirstName());
        assertEquals("Doe", employeeList.get(0).getLastName());
        assertEquals("john.doe@example.com", employeeList.get(0).getEmail());
        assertEquals("Developer", employeeList.get(0).getTitle());
    }

    @Test
    public void testGetEmployeeList() {
        Employee employee1 = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
        Employee employee2 = new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager");

        employees.addEmployee(employee1);
        employees.addEmployee(employee2);

        List<Employee> employeeList = employees.getEmployeeList();
        assertEquals(2, employeeList.size());

        assertTrue(employeeList.stream().anyMatch(e -> e.getEmployeeId().equals("1") && e.getFirstName().equals("John")));
        assertTrue(employeeList.stream().anyMatch(e -> e.getEmployeeId().equals("2") && e.getFirstName().equals("Jane")));
    }
}