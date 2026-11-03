package org.example._8_spring_jdbc_tut.repository;

import org.example._8_spring_jdbc_tut.models.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Student> mapper = new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createStudent(Student student) {
        String sql = """
                INSERT into students(name, email, age)
                VALUES (?, ?, ?)""";
        int update = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getAge());
        if(update == 1) {
            return "Student created successfully!";
        }
        return "Student not created successfully!";
    }

    public Student getStudentById(Long id) {
        String sql = """
                SELECT * FROM students WHERE id = ?
                """;
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    public List<Student> getAllStudents() {
        String sql = """
                SELECT * FROM students
                """;
        return jdbcTemplate.query(sql, mapper);
    }
}
