package com.maticode.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maticode.dtos.StaffViewDTO;

public class StaffViewRowMapper implements RowMapper<StaffViewDTO> {

	@Override
	public StaffViewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		return StaffViewDTO.builder().staffID(rs.getInt("ID")).name(rs.getString("name"))
				.address(rs.getString("address")).zipCode(rs.getString("zip_code")).phoneNumber(rs.getString("phone"))
				.city(rs.getString("city")).country(rs.getString("country")).build();

	}
}
