package com.LAB.ABCLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            // Generate unique numeric ID
            String generatedId = generateNumericId();

            // Set the auto-generated ID
            user.setId(generatedId);

            // Save the user object to the database
            User savedUser = userRepo.save(user);
            return new ResponseEntity<>("User added successfully with ID: " + savedUser.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            // Retrieve all users from the database
            List<User> users = userRepo.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to generate a unique numeric ID
    private String generateNumericId() {
        // Generate a random UUID and return only the numeric part
        String uuid = UUID.randomUUID().toString().replaceAll("[^\\d.]", "");
        return uuid.substring(0, Math.min(uuid.length(), 10)); // Limit to 10 digits
    }
}



