package org.example._1_ems.services;

import org.example._1_ems.dtos.EmployeeRequestDTO;
import org.example._1_ems.dtos.EmployeeResponseDTO;
import org.example._1_ems.utils.EmployeeUtilsDto;
import org.example._1_ems.models.Employee;
import org.example._1_ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeUtilsDto employeeUtilsDto;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeUtilsDto employeeUtilsDto) {
        this.employeeRepository = employeeRepository;
        this.employeeUtilsDto = employeeUtilsDto;
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeUtilsDto.mapToEntity(employeeRequestDTO);

        Employee createdEmployee = employeeRepository.save(employee);

        return employeeUtilsDto.mapToDTO(createdEmployee);

    }

    public EmployeeResponseDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(employeeUtilsDto::mapToDTO).orElse(null);
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOS = new ArrayList<>();
        for(Employee employee : employees) {
            employeeResponseDTOS.add(employeeUtilsDto.mapToDTO(employee));
        }
        return employeeResponseDTOS;
    }

    public boolean deleteEmployeeById(Long id) {
        boolean employeeExists = employeeRepository.existsById(id);
        if(employeeExists) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO employeeRequestDTO) {
        boolean employeeExists = employeeRepository.existsById(id);
        if(!employeeExists) {
            return null;
        }
        Employee employee = employeeUtilsDto.mapToEntity(employeeRequestDTO);
        employee.setId(id);
        employeeRepository.save(employee);
        return employeeUtilsDto.mapToDTO(employee);
    }

}
