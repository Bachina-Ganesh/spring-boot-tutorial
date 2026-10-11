package com.example._9_sms.repository;

import com.example._9_sms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findAllByDeletedIsFalse();
}
