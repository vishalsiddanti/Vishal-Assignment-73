package com.springboot.docker.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.docker.model.Employee;
import com.springboot.docker.repository.EmployeeRepository;


@RestController
@RequestMapping("/employees")
public class MainRestController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Logger logger = Logger.getLogger(MainRestController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAll() {
		logger.debug("Default addess : /employees - GET Request");
		
		List<Employee> employees = employeeRepository.findAll();
		logger.debug(employees);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalEmployees", employees.size());
	    response.put("employees", employees);
	    return response;
	}
	
	@RequestMapping(value="/id/{id}", method = RequestMethod.GET)
	public Map<String, Object> getEmployee(@PathVariable("id") Long id) {
		logger.debug("/"+id+" address");
		
		Employee emp = employeeRepository.getEmpById(id);
		logger.debug(emp);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Fetching Employee details successfull");
	    response.put("employee", emp);
	    return response;
	}
	
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
	public Map<String, Object> getEmployeeByName(@PathVariable("name") String name) {
		logger.debug("/"+name+" address");
		
		Employee emp = employeeRepository.getEmpByName(name);
		logger.debug(emp);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Fetching Employee details successfull");
	    response.put("employee", emp);
	    return response;
	}
	
	@RequestMapping(value="/new/", method = RequestMethod.POST)
	public Map<String, Object> createEmployee(@RequestBody Employee emp) {
		Employee employee = new Employee(emp.getId(), emp.getName(), emp.getAge(), emp.getYears());
		employeeRepository.save(employee);
		logger.debug("employee created succesfully: "+employee);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Employee created successfully");
	    response.put("employee", employee);
	    return response;
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
		Employee employee = new Employee(id, emp.getName(), emp.getAge(), emp.getYears());
		employeeRepository.save(employee);
		logger.debug("employee updated succesfully: "+employee);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Employee updated successfully");
	    response.put("employee", employee);
	    return response;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deleteEmployee(@PathVariable("id") Long id) {
		employeeRepository.delete(id);
		Map<String, String> response = new HashMap<String, String>();
	    response.put("message", "Employee deleted successfully");
	    return response;
	}

}
