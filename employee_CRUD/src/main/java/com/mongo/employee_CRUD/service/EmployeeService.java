package com.mongo.employee_CRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.employee_CRUD.entity.Employee;
import com.mongo.employee_CRUD.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepo emprepo;
	
	public List<Employee> findAllEmployees() {
        return emprepo.findAll();
    }

    public Optional<Employee> findEmployeeById(String id) {
        return emprepo.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return emprepo.save(employee);
    }


}
