package com.maticode.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.maticode.dtos.ActorDTO;

@SuppressWarnings("deprecation")
public class ActorRowMapper implements RowMapper<ActorDTO> {

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	public ActorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		// Para pasar de un timestamp 'YYYY-MM-DD HH:MM:SS' a un string 'dd/MM/yyyy'
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String formattedDate = dateFormat.format(rs.getTimestamp("last_update"));

		// Para pasar de MATIAS MARTIN a Matias Martin
		String firstNameFormateado = WordUtils.capitalize(rs.getString("first_name").toLowerCase());
		String lastNameFormateado = WordUtils.capitalize(rs.getString("last_name").toLowerCase());

		return ActorDTO.builder().actorId(rs.getLong("actor_id")).firstName(firstNameFormateado)
				.lastName(lastNameFormateado).lastUpdate(formattedDate).build();
	}
}