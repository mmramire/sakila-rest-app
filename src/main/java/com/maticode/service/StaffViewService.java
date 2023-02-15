package com.maticode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.dtos.StaffViewDTO;
import com.maticode.repository.StaffViewRepositoryImpl;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StaffViewService {
	@Autowired
	StaffViewRepositoryImpl staffViewRepositoryImpl;

	public List<StaffViewDTO> listAll() {
		return staffViewRepositoryImpl.findAllStaffMembers();
	}

}
