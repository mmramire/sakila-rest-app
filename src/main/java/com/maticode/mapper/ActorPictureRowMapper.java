package com.maticode.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ActorPictureRowMapper implements RowMapper<Blob> {

	public Blob mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getBlob(1);
	}
}