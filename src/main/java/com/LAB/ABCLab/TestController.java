package com.LAB.ABCLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class TestController {

    @Autowired
    private TestRepo testRepo;


    @PostMapping("/tests")
    public ResponseEntity<String> addTest(@RequestBody Test test) {
        try {
            // Save the test object to the database
            Test savedTest = testRepo.save(test);
            return new ResponseEntity<>("Test added successfully with ID: " + savedTest.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add test: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getAllTests() {
        try {
            // Retrieve all tests from the database
            List<Test> tests = testRepo.findAll();
            return new ResponseEntity<>(tests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Method to delete a test by ID
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable Integer id) {
        try {
            // Check if the test exists
            if (testRepo.existsById(id)) {
                // Delete the test from the database
                testRepo.deleteById(id);
                return new ResponseEntity<>("Test with ID " + id + " deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Test with ID " + id + " not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete test: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //http://localhost:8080/remove


}



