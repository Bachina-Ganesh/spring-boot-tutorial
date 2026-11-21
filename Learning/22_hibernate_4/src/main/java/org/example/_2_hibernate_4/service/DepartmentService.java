package org.example._2_hibernate_4.service;

import org.example._2_hibernate_4.model.Department;
import org.example._2_hibernate_4.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public String save(Department department) {
        this.departmentRepository.save(department);
        return "Department Created Successfully!";
    }

    @Transactional
    public Department findById(Long id) {
        return this.departmentRepository.findById(id);
    }

    @Transactional
    public String remove(Long id) {
        Department department = this.departmentRepository.findById(id);
        this.departmentRepository.delete(department);
        return "Department Deleted Successfully!";
    }
}
