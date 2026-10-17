package org.example.pms.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {
    @NotBlank(message = "Name should not be blank")
    @NotNull(message = "Name should not be null")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Email(message = "Email should be a valid email")
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "MobileNumber should be valid one")
    private String mobileNumber;

    @NotBlank(message = "Address should not be blank")
    @NotNull(message = "Address should not be null")
    @NotEmpty(message = "Address should not be empty")
    private String address;
}
