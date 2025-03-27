package com.shubham.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Employee findByEmail(String email);
}
