package org.example.pms.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MethodArgResponseDTO {
    private LocalDateTime timestamp;
    private String message;
    private String statusMessage;
    private int statusCode;
    private String path;
    private Map<String, String> fieldErrors;
}
