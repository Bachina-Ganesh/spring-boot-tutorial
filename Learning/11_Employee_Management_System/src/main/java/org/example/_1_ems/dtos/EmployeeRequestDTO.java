package org.example._1_ems.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    @NotBlank(message = "Name should not be blank")
    @NotEmpty(message = "Name should not be empty")
    @NotNull(message = "Name should not be null")
    private String name;

    @Email(message = "Provide a valid email id")
    @NotNull(message = "Email should not be null")
    private String email;

    @Min(value = 1000, message = "Minimum salary should be 1000")
    @Max(value = 10000, message = "Maximum salary should be 100000")
    private Double salary;

    @NotNull(message = "Address should not be null")
    @NotBlank(message = "Address should not be blank")
    @NotEmpty(message = "Address should not be empty")
    private String address;
}
