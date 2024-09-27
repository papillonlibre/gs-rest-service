package com.my_implementation;

// Creating an entity Employee 
public class Employee { 

    // Private variables for employee_id, first_name, last_name, email, and title
    private Integer employee_id; 
    private String first_name; 
    private String last_name; 
    private String email; 
    private String title;  // Add the title variable

    // Default constructor 
    public Employee() {} 

    // Parameterized Constructor 
    // to assign the values 
    // to the properties of 
    // the entity 
    public Employee(Integer id, String firstName, String lastName, String email, String title) { 
        super(); 
        this.employee_id = id; 
        this.first_name = firstName; 
        this.last_name = lastName; 
        this.email = email; 
        this.title = title;  // Initialize the title
    } 

    // Overriding the toString method 
    // to find all the values 
    @Override
    public String toString() { 
        return "Employee [id=" + employee_id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email + ", title=" + title + "]"; 
    } 

    // Getters of the properties 
    public Integer getId() { 
        return employee_id; 
    }

    public void setId(Integer id) {
        this.employee_id = id;
    }

    public String getFirstName() { 
        return last_name; 
    } 

    public void setFirstName(String name) {
        this.first_name = name;
    }

    public String getLastName() { 
        return last_name; 
    } 

    public void setLastName(String name) {
        this.last_name = name;
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {  // Getter for the title
        return title; 
    } 

    public void setTitle(String title) {
        this.title = title;
    }
}
