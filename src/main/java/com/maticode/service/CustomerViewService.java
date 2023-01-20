package com.maticode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.customer_data_model.CustormerView;
import com.maticode.repository.CustomerViewRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerViewService {

	@Autowired
	CustomerViewRepository repo;

	public List<CustormerView> listAll() {
		return repo.findAll();
	}
}
