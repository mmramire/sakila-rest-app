package com.maticode.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maticode.dtos.FilmViewDTO;

public class FilmViewRowMapper implements RowMapper<FilmViewDTO> {

	@Override
	public FilmViewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		return FilmViewDTO.builder().filmID(rs.getInt("FID")).title(rs.getString("title"))
				.description(rs.getString("description")).category(rs.getString("category")).price(rs.getLong("price"))
				.length(rs.getInt("length")).rating(rs.getString("rating")).actors(rs.getString("actors")).build();

	}
}
