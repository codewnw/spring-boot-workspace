package com.codewnw.springboot.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerRestController {

	List<Customer> customers = new ArrayList<>();

	public CustomerRestController() {
		customers.add(new Customer(1l, "Rohit", 55));
		customers.add(new Customer(2l, "Virat", 35));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomers() {
		return ResponseEntity.ok(customers);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer getCustomer(@PathVariable("id") Long id) {
		return customers.stream().filter(customer -> customer.getId() == id).findFirst().orElse(null);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		customers.add(customer);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		customers = customers.stream().filter(cust -> cust.getId() != customer.getId()).collect(Collectors.toList());
		customers.add(customer);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
		customers = customers.stream().filter(cust -> cust.getId() != id).collect(Collectors.toList());
		return ResponseEntity.ok().build();
	}
}
