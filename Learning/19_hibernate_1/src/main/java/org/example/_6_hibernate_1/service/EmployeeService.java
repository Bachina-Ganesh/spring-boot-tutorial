package org.example._6_hibernate_1.service;


import org.example._6_hibernate_1.entites.Employee;
import org.example._6_hibernate_1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public String createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findEmployee(id);
    }

    @Transactional
    public String deleteEmployee(Long id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Transactional
    public String updateEmployee(Employee employee, Long id) {
        return employeeRepository.updateEmployee(employee, id);
    }
}
