package org.example._1_hibernate_3.controller;

import org.example._1_hibernate_3.models.Profile;
import org.example._1_hibernate_3.repository.ProfileRepository;
import org.example._1_hibernate_3.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<String> createProfile(@RequestBody Profile profile) {
        String response =  profileService.createProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }
}
