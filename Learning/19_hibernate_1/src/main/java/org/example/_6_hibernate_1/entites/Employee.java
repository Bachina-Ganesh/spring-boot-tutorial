package org.example._6_hibernate_1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example._6_hibernate_1.convertes.EmployeeActiveConverter;
import org.example._6_hibernate_1.enums.Gender;

import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "student_name",
            nullable = false,
            length = 100
    )
    private String name;
    @Column(
            name = "student_email",
            nullable = false,
            unique = true
    )
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Convert(converter = EmployeeActiveConverter.class)
    private Boolean isActive;

    @Transient
    private String password;

    @Embedded
    private Address cityAddress;

    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private List<String> skills;
}
