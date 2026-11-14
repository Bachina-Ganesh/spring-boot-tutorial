package org.example._1_hibernate_3.service;

import org.example._1_hibernate_3.models.Profile;
import org.example._1_hibernate_3.models.User;
import org.example._1_hibernate_3.repository.ProfileRepository;
import org.example._1_hibernate_3.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public String createProfile(Profile profile) {
        User user = profile.getUser();
        this.userRepository.createUser(user);
        this.profileRepository.createProfile(profile);
        return "Profile created successfully";
    }

    @Transactional
    public Profile getProfileById(Long id) {
        return this.profileRepository.getProfileById(id);
    }
}
