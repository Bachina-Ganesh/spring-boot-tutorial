package org.example.models;

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
