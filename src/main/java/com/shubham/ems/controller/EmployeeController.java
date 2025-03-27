package com.shubham.ems.controller;

import com.shubham.ems.dto.EmployeeDto;
import com.shubham.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:3000") // for local workspace development
@CrossOrigin("https://serviceportal.netlify.app")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDto = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDto);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);

        return ResponseEntity.ok(employeeDto);
    }

    // Build create multiple Employees REST API
    @PostMapping("/bulk")
    public ResponseEntity<List<EmployeeDto>> createEmployess(@RequestBody List<EmployeeDto> employeeDtos) {
        List<EmployeeDto> savedEmployees = employeeService.createEmployees(employeeDtos);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    // Build delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee has been deleted Successfully!!!", HttpStatus.NO_CONTENT);
    }

    // Build update id by email REST API
//    @PutMapping("/email/{email}")
//    public ResponseEntity<EmployeeDto> updateEmployeeByEmail(@PathVariable("email") String employeeEmail, @RequestBody EmployeeDto employeeDto) {
//        EmployeeDto updatedEmployee = employeeService.updateEmployeeIdByEmail(employeeEmail, employeeDto);
//        return ResponseEntity.ok(updatedEmployee);
//    }


}
