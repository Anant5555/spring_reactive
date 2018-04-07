package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{

}
