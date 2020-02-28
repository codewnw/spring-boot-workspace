package com.codewnw.springboot.customer;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Customer {

	private Long id;

	private String name;

	private int age;

	public Customer() {
		super();
	}

	public Customer(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
