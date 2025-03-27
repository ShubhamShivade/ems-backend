package com.shubham.ems.mapper;

import com.shubham.ems.dto.EmployeeDto;
import com.shubham.ems.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail().toLowerCase()
				);
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail().toLowerCase()
		);
	}

}
