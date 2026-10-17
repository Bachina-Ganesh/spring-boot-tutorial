package org.example.pms.utils;

import org.example.pms.dtos.PatientRequestDTO;
import org.example.pms.dtos.PatientResponseDTO;
import org.example.pms.models.Patient;

public class DTOConverter {
    public static Patient mapToEntity(PatientRequestDTO patientRequestDTO) {
        return Patient.builder()
                .name(patientRequestDTO.getName())
                .email(patientRequestDTO.getEmail())
                .mobileNumber(patientRequestDTO.getMobileNumber())
                .address(patientRequestDTO.getAddress())
                .build();
    }

    public static PatientResponseDTO mapToDTO(Patient patient) {
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .build();
    }
}
