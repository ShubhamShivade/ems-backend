package com.shubham.ems.service;

import com.shubham.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

    List<EmployeeDto> createEmployees(List<EmployeeDto> employeeDtos);

//    EmployeeDto updateEmployeeIdByEmail(String employeeEmail, EmployeeDto employeeDto);


}
