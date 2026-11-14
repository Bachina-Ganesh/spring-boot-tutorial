package org.example._1_hibernate_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._1_hibernate_3.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
