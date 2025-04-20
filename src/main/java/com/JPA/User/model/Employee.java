package com.JPA.User.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Employee")
public class Employee {
    @Id
    private Long employee_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobTitle;
    private String department;
    private Double salary;
    private Boolean isActive;
}
