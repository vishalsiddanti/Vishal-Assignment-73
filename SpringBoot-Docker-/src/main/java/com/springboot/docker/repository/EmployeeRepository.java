package com.springboot.docker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.docker.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
	
	public Employee getEmpById(Long id);
	public Employee getEmpByName(String name);
	
}
