package com.rahal.model;

public class Person {
	
	private int id;
	private String name;
	private int age;
	private PersonAddress address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public PersonAddress getAddress() {
		return address;
	}
	public void setAddress(PersonAddress address) {
		this.address = address;
	}
	
	
	
}
