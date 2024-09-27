package com.my_implementation;

import com.my_implementation.Employee;
import com.my_implementation.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Employees employees;

    public EmployeeController() {
        this.employees = new Employees();
        // Adding some sample employees
        employees.addEmployee(new Employee(1, "John", "Doe", "john.doe@example.com", "Developer"));
        employees.addEmployee(new Employee(2, "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employees.addEmployee(new Employee(3, "Jim", "Beam", "jim.beam@example.com", "Designer"));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees.getEmployeeList();
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employees.addEmployee(employee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }
}
