package com.maticode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maticode.customer_data_model.CustormerView;

public interface CustomerViewRepository extends JpaRepository<CustormerView, Integer> {

}
