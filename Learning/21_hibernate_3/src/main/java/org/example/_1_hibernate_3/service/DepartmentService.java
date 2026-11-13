package org.example._1_hibernate_3.service;

import org.example._1_hibernate_3.models.Department;
import org.example._1_hibernate_3.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String createDepartment(Department department) {
        departmentRepository.saveDepartment(department);
        return "Department Created Successfully";
    }

    @Transactional
    public Department getDepartment(Long id) {
        return departmentRepository.getDepartment(id);
    }
}
