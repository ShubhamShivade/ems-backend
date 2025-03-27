package com.shubham.ems.service.impl;

import com.shubham.ems.dto.EmployeeDto;
import com.shubham.ems.entity.Employee;
import com.shubham.ems.exception.ResourceNotFoundException;
import com.shubham.ems.mapper.EmployeeMapper;
import com.shubham.ems.repository.EmployeeRepository;
import com.shubham.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect(Collectors.toList());


    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDto> createEmployees(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = employeeDtos.stream()
                .map(EmployeeMapper::mapToEmployee)
                .collect(Collectors.toList());

        List<Employee> savedEmployees = employeeRepository.saveAll(employees);

        return savedEmployees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public EmployeeDto updateEmployeeIdByEmail(String employeeEmail, EmployeeDto employeeDto) {
//        Employee employee = employeeRepository.findByEmail(employeeEmail);
//        employee.setId(employeeDto.getId());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//
//        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
//    }


}
