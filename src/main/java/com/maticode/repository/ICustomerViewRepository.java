package com.maticode.repository;

import java.util.List;

import com.maticode.dtos.CustomerViewDTO;

public interface ICustomerViewRepository {

	List<CustomerViewDTO> findAllCustomers();
}
