package com.LAB.ABCLab;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepo extends MongoRepository<Appointment, Integer> {

}
