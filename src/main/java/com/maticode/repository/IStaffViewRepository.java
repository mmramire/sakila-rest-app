package com.maticode.repository;

import java.util.List;

import com.maticode.dtos.StaffViewDTO;

public interface IStaffViewRepository {
	List<StaffViewDTO> findAllStaffMembers();
}
