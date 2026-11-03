package org.example.repository;

import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static String url = "jdbc:mysql://localhost:3306/student_db";
    private static String username = "root";
    private static String password = "root";

//    create student
    public void createStudent(Student student) {
        String sql = """
                INSERT INTO students(name, email, age)
                VALUES(?, ?, ?)
                """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            preparedStatement.executeUpdate();

            System.out.println("Student created successfully");
        }
        catch (SQLException e) {
            System.out.println("Student creation failed");
            e.printStackTrace();
        }
    }

//    get student by id
    public void getStudentById(Long id) {
        String sql = """
                SELECT id, name, email, age
                FROM students WHERE id = ?
                """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Student fetchedStudent = new Student();
            while (resultSet.next()) {
                fetchedStudent.setId(resultSet.getLong("id"));
                fetchedStudent.setName(resultSet.getString("name"));
                fetchedStudent.setEmail(resultSet.getString("email"));
                fetchedStudent.setAge(resultSet.getInt("age"));
            }
            System.out.println("Student fetched successfully : " + fetchedStudent);
        }
        catch (SQLException e) {
            System.out.println("Fetch student by id failed");
            e.printStackTrace();
        }
    }

//    get all students
    public void getAllStudents() {
        String sql = """
                SELECT id, name, email, age
                FROM students
                """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> fetchedStudents = new ArrayList<>();
            while (resultSet.next()) {
                Student fetchedStudent = new Student();
                fetchedStudent.setId(resultSet.getLong("id"));
                fetchedStudent.setName(resultSet.getString("name"));
                fetchedStudent.setEmail(resultSet.getString("email"));
                fetchedStudent.setAge(resultSet.getInt("age"));
                fetchedStudents.add(fetchedStudent);
            }
            System.out.println("All students fetched successfully : " + fetchedStudents);
        }
        catch (SQLException e) {
            System.out.println("Fetch all students failed");
            e.printStackTrace();
        }
    }

//    update student by id
    public void updateStudent(Student student, Long id) {
        String sql = """
                UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?
                """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Student updated successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

//    delete student by id
    public void deleteStudentById(Long id) {
        String sql = """
                DELETE FROM students WHERE id = ?
                """;
        try(
               Connection connection = DriverManager.getConnection(url, username, password);
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Student deleted successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
