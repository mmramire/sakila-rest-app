package com.maticode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maticode.customer_data_model.CustormerView;
import com.maticode.service.CustomerViewService;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

	@Autowired
	private CustomerViewService cvs;

	@GetMapping(value = "/all")
	public ResponseEntity<List<CustormerView>> getAllCustomers() {
		List<CustormerView> customers = cvs.listAll();
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
