package com.LAB.ABCLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @PostMapping("/appointments")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment) {
        try {
            // Generate unique id and appointment number
            String generatedId = UUID.randomUUID().toString();
            String generatedNo = generateAppointmentNo();

            // Set the auto-generated fields
            appointment.setId(generatedId);
            appointment.setNo(generatedNo);

            // Save the appointment object to the database
            Appointment savedAppointment = appointmentRepo.save(appointment);
            return new ResponseEntity<>("Appointment added successfully with ID: " + savedAppointment.getId() +
                    " and No: " + savedAppointment.getNo(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add appointment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to generate an appointment number (e.g., can be a random or sequential number)
    private String generateAppointmentNo() {
        // Your implementation to generate appointment number
        // For example:
        // return UUID.randomUUID().toString().substring(0, 6); // Generates a random UUID and takes first 6 characters
        return "APPT" + UUID.randomUUID().toString().substring(0, 6); // Sample sequential appointment number
    }
}
