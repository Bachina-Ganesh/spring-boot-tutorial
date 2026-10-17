package org.example.pms.service;

import org.example.pms.dtos.PatientRequestDTO;
import org.example.pms.dtos.PatientResponseDTO;
import org.example.pms.exceptions.DuplicateResourceFoundException;
import org.example.pms.exceptions.ResourceNotFoundException;
import org.example.pms.models.Patient;
import org.example.pms.repository.PatientRepository;
import org.example.pms.utils.DTOConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        boolean isPatientExists = this.patientRepository.existsByEmail(patientRequestDTO.getEmail());

        if(isPatientExists) {
            throw new DuplicateResourceFoundException("Patient with email " + patientRequestDTO.getEmail() + " already exists");
        }

        Patient patient = DTOConverter.mapToEntity(patientRequestDTO);
        Patient createdPatient = this.patientRepository.save(patient);

        return DTOConverter.mapToDTO(createdPatient);
    }

    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = this.patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient with id " + id + " not found"));
        return DTOConverter.mapToDTO(patient);
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = this.patientRepository.findAll();
        return patients.stream()
                .map(DTOConverter::mapToDTO)
                .toList();
    }

    public void deletePatientById(Long id) {
        boolean patientExists = this.patientRepository.existsById(id);
        if(patientExists) {
            this.patientRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Patient with id " + id + " not found");
        }
    }

    public PatientResponseDTO updatePatientById(Long id, PatientRequestDTO patientRequestDTO) {
        Patient patient = this.patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient with id " + id + " not found"));

        boolean patientExists = this.patientRepository.existsByEmail(patientRequestDTO.getEmail());
        if(patientExists) {
            throw new DuplicateResourceFoundException("Patient with email " + patientRequestDTO.getEmail() + " already exists");
        }

        Patient tobeUpdatedPatient = DTOConverter.mapToEntity(patientRequestDTO);
        tobeUpdatedPatient.setId(id);

        Patient updatedPatient = this.patientRepository.save(tobeUpdatedPatient);

        return DTOConverter.mapToDTO(updatedPatient);
    }
}
