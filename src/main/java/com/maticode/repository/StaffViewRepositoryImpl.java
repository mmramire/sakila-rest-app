package com.maticode.repository;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maticode.dtos.StaffViewDTO;
import com.maticode.mapper.StaffViewRowMapper;
import com.maticode.queries.SQLCommands;

/**
 * Repositorio que se encarga de realizar operaciones de consulta a la vista
 * "staff_list" en la base de datos. Implementa la interfaz
 * {@link IStaffViewRepository}.
 * 
 * @author mmram
 * @since 15/02/2023
 */
@Repository
public class StaffViewRepositoryImpl implements IStaffViewRepository {
	private static final String SELECT_STAFF_LIST_PARTIAL_DATA = SQLCommands.SELECT_STAFF_LIST_PARTIAL_DATA;

	/**
	 * Inyección del objeto JdbcTemplate para acceder a la base de datos.
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Constructor para inicializar el objeto JdbcTemplate con un objeto DataSource.
	 *
	 * @param dataSource DataSource para acceder a la base de datos.
	 */
	public StaffViewRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Método que se encarga de recuperar el staff de las store de la vista
	 * "staff_list".
	 * 
	 * @return Lista de objetos {@link StaffViewDTO} con la información de los
	 *         miembros.
	 */
	public List<StaffViewDTO> findAllStaffMembers() {
		List<StaffViewDTO> staffList;
		try {
			staffList = jdbcTemplate.query(SELECT_STAFF_LIST_PARTIAL_DATA, new StaffViewRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		return staffList;
	}

}
