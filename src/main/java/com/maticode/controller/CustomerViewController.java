package com.maticode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maticode.model.CustormerView;
import com.maticode.service.CustomerViewService;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

	@Autowired
	private CustomerViewService cvs;

	@GetMapping(value = "/all")
	public @ResponseBody List<CustormerView> getAllCustomers() {
		return (List<CustormerView>) cvs.listAll();
	}

}
