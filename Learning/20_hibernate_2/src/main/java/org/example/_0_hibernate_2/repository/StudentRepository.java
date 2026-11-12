package org.example._0_hibernate_2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._0_hibernate_2.models.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String createStudent(Student student) {
        entityManager.persist(student);
        return "Student created successfully";
    }

    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public String deleteStudentById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        return  "Student deleted successfully";
    }

    public void detachStudent(Student student) {
        entityManager.detach(student);
    }
    public void attachStudent(Student student) {
        entityManager.merge(student);
    }
    public void flush(Student student) {
        entityManager.flush();
    }

}
