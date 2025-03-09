package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.User;
import com.portal_backend.job_portal.repositories.ApplicationRepository;
import com.portal_backend.job_portal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationRepository applicationRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationRepository applicationRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.applicationRepository = applicationRepository;
    }

    @Transactional
    public User registerUser(User user) {
        return userRepository.save(user);  // Ensure user is saved first
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(Long id) {
        // Remove all applications associated with the user before deleting the user
        applicationRepository.deleteByJobSeekerId(id);

        // Now delete the user
        userRepository.deleteById(id);
    }

}