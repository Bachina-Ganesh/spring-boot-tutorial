package org.example._6_hibernate_1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._6_hibernate_1.entites.Employee;
import org.example._6_hibernate_1.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    create employee
    public String createEmployee(Employee employee) {
        entityManager.persist(employee);
        return "Employee created successfully";
    }

//    get employee
    public Employee findEmployee(Long id) {
        return entityManager.find(Employee.class, id);
    }

//    remove employee
    public String deleteEmployee(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        entityManager.remove(employee);
        return "Employee deleted with an id: "+id;
    }

    public String updateEmployee(Employee updatedEmployee, Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        updatedEmployee.setId(id);
        entityManager.merge(updatedEmployee);
        return "Employee updated with an id: "+id;
    }
}
