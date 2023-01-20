package com.maticode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maticode.customer_data_model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByCustomerId(Integer customerId);

	Customer findByEmail(String email);
}
