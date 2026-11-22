package org.example._3_spring_data_jpa.repository;

import org.example._3_spring_data_jpa.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @EntityGraph(attributePaths = "profile")
    @Query("SELECT s FROM Student s WHERE s.id =:id")
    Optional<Student> findByIds(@Param(value = "id") Long id);
}
