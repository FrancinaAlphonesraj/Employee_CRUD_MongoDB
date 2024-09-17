package com.mongo.employee_CRUD.entity;

import lombok.*;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
	
	@Id
    private String id;
	
	private String employeename;
	
	private String email;
	
	private String location;
	
	
}
