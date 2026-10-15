package org.example._1_ems.utils;

import org.example._1_ems.dtos.EmployeeRequestDTO;
import org.example._1_ems.dtos.EmployeeResponseDTO;
import org.example._1_ems.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtilsDto {

    public Employee mapToEntity(EmployeeRequestDTO employeeRequestDTO) {
        return Employee.builder().name(employeeRequestDTO.getName())
                .salary(employeeRequestDTO.getSalary())
                .email(employeeRequestDTO.getEmail())
                .address(employeeRequestDTO.getAddress())
                .build();
    }

    public EmployeeResponseDTO mapToDTO(Employee employee) {
        return EmployeeResponseDTO.builder()
                .name(employee.getName())
                .email(employee.getName())
                .address(employee.getAddress())
                .id(employee.getId())
                .build();
    }
}
