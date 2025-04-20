package com.JPA.User.service;

import com.JPA.User.model.Employee;
import com.JPA.User.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Optional<Employee> getEmployeeById(Long id) {
        return empRepo.findById(id);
    }

    public List<Employee> getAllUsers() {
        return empRepo.findAll();
    }

    public Employee getUserByEmail(String email) {
        return empRepo.findByEmail(email);
    }

    public Optional<Employee> getUserByEmailID(String email) {
        return empRepo.findEmpByEmail(email);
    }

    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

}
