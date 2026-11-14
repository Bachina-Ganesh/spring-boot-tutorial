package org.example._1_hibernate_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example._1_hibernate_3.models.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public ProfileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createProfile(Profile profile) {
        entityManager.persist(profile);
    }

    public Profile getProfileById(Long id) {
        return entityManager.find(Profile.class, id);
    }
}
