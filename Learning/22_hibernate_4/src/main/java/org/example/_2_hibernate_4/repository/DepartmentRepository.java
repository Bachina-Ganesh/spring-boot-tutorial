package org.example._2_hibernate_4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._2_hibernate_4.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }

    public void delete(Department department) {
        entityManager.remove(department);
    }
}
