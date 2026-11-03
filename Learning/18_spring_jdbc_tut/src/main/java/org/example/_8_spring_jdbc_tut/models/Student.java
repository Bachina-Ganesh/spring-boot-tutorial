package org.example._8_spring_jdbc_tut.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Long id;
    private String name;
    private String email;
    private int age;
}
