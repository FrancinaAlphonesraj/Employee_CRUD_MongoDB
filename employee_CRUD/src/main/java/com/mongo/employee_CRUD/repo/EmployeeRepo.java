package com.mongo.employee_CRUD.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.employee_CRUD.entity.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String>{

}
