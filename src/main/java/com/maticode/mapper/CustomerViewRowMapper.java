package com.maticode.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maticode.dtos.CustomerViewDTO;

public class CustomerViewRowMapper implements RowMapper<CustomerViewDTO> {

	@Override
	public CustomerViewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		String[] nombreApellido = rs.getString("name").split(" ");

		return CustomerViewDTO.builder().customerID(rs.getInt("ID")).firstName(nombreApellido[0])
				.lastName(nombreApellido[1]).phoneNumber(rs.getString("phone")).city(rs.getString("city"))
				.country(rs.getString("country")).build();

	}

}
