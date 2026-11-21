package org.example._2_hibernate_4.repository;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._2_hibernate_4.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void remove(Student student) {
        entityManager.remove(student);
    }

    public List<Student> getStudents() {

        EntityGraph<Student> entityGraph =
                entityManager.createEntityGraph(Student.class);

        entityGraph.addAttributeNodes("department", "profile");

        return entityManager.createQuery(
                        "SELECT s FROM Student s", Student.class
                )
                .setHint("jakarta.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}
