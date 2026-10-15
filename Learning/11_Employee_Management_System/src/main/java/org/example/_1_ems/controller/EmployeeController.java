package org.example._1_ems.controller;

import jakarta.validation.Valid;
import org.example._1_ems.dtos.EmployeeRequestDTO;
import org.example._1_ems.dtos.EmployeeResponseDTO;
import org.example._1_ems.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.createEmployee(employeeRequestDTO);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable Long id) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeById(id);
        if(employeeResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        if(isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>("Employee not found with an id : "+id, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO, @PathVariable Long id) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployeeById(id, employeeRequestDTO);
        if(employeeResponseDTO == null) {
            return new ResponseEntity<>("Employee not found with an id : "+id, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeResponseDTO);
    }
}
