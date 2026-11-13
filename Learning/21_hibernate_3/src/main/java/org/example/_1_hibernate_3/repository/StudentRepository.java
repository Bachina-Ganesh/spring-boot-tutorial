package org.example._1_hibernate_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._1_hibernate_3.models.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public Student getStudent(Long id) {
        return entityManager.find(Student.class, id);
    }
}
