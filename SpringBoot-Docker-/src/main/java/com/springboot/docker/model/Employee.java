package com.springboot.docker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Employees")
public class Employee {
	
	@Id
	private ObjectId _id;
	
	@Field(value="id")
	private Long id;
	
	@Field(value="name")
	private String name;
	
	@Field(value="age")
	private int age;
	
	@Field(value="years")
	private int years;
	
	public Employee() {}
	
	public Employee(String name, int age, int years) {
		this.name = name;
		this.age = age;
		this.years = years;
	}
	

	public Employee(Long id, String name, int age, int years) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.years = years;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", years=" + years + "]";
	}
		
}
