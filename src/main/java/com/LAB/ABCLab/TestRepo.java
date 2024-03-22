package com.LAB.ABCLab;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepo extends MongoRepository<Test, Integer> {
}
