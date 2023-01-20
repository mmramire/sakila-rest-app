package com.maticode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maticode.customer_data_model.Customer;
import com.maticode.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id) {
		Optional<Customer> customer = customerService.findById(id);
		if (!customer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer.get());
	}
}
