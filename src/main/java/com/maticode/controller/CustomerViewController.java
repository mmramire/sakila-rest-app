package com.maticode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maticode.dtos.CustomerViewDTO;
import com.maticode.service.CustomerViewService;

@RestController
@RequestMapping("/customers")
public class CustomerViewController {

	@Autowired
	private CustomerViewService customerViewService;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerViewDTO> getAllCustomers() {
		return customerViewService.listAll();
	}

}
