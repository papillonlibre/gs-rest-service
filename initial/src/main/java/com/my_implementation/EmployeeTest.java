package com.my_implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
    }

    @Test
    public void testGetEmployeeId() {
        assertEquals("1", employee.getEmployeeId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", employee.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", employee.getLastName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", employee.getEmail());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Developer", employee.getTitle());
    }