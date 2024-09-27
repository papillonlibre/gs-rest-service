package com.my_implementation;

import com.my_implementation.Employee;
import com.my_implementation.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Employees employees;

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setup() {
        employee1 = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
        employee2 = new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager");
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        given(employees.getEmployeeList()).willReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].employeeId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].employeeId").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("Jane"))
                .andDo(print());
    }

    @Test
    public void testAddEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"employeeId\": \"3\", \"firstName\": \"Jim\", \"lastName\": \"Beam\", \"email\": \"jim.beam@example.com\", \"title\": \"Designer\" }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Employee added successfully"))
                .andDo(print());
    }
}