package org.example._1_hibernate_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._1_hibernate_3.models.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveDepartment(Department department) {
        entityManager.persist(department);
    }

    public Department getDepartment(Long id) {
        return entityManager.find(Department.class, id);
    }
}
