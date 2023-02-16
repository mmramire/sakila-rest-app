package com.maticode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.dtos.CustomerViewDTO;
import com.maticode.repository.CustomerViewRepositoryImpl;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerViewService {

	@Autowired
	CustomerViewRepositoryImpl customerViewRepositoryImpl;

	public List<CustomerViewDTO> listAll() {

		return customerViewRepositoryImpl.findAllCustomers();

	}
}
