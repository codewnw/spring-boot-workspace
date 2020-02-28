package com.codewnw.springboot.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerRestController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomers() {
		return ResponseEntity.ok(customerRepository.findAll());
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		return ResponseEntity.ok(customerRepository.findById(id).orElse(null));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
