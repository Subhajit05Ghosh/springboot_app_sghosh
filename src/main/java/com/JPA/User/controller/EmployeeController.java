package com.JPA.User.controller;

import com.JPA.User.model.Employee;
import com.JPA.User.model.ErrorResponse;
import com.JPA.User.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping("/employee")
    public List<Employee> getAllUsers() {
        return empService.getAllUsers();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = empService.getEmployeeById(id);
        return employee;
    }

    @GetMapping("/employee/get/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long id) {
        return empService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/ID/{id}")
    public ResponseEntity<Object> getEmployeeDetailsById(@PathVariable Long id) {
        Optional<Employee> employee = empService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("EMPLOYEE_NOT_FOUND", "Employee with ID " + id + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

    }

    @PostMapping("/add/emp")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = empService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/emp/{email}")
    public Employee getUserByEmail(@PathVariable String email) {
        return empService.getUserByEmail(email);
    }


    @GetMapping("/empID/{email}")
    public ResponseEntity<Object> getUserByEmailID(@PathVariable String email) {
        Optional<Employee> userByEmailID = empService.getUserByEmailID(email);
        if (userByEmailID.isPresent()) {
            return ResponseEntity.ok(userByEmailID.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("EMPLOYEE_NOT_FOUND", "Employee with Email ID " + email + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}
