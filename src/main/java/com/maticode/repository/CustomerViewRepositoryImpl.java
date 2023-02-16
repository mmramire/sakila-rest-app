package com.maticode.repository;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maticode.dtos.CustomerViewDTO;
import com.maticode.mapper.CustomerViewRowMapper;
import com.maticode.queries.SQLCommands;

/**
 * Repositorio que se encarga de realizar operaciones de consulta a la vista
 * "customer_list" en la base de datos. Implementa la interfaz
 * {@link ICustomerViewRepository}.
 * 
 * @author mmram
 * @since 31/01/2023
 */
@Repository
public class CustomerViewRepositoryImpl implements ICustomerViewRepository {

	private static final String SELECT_CUSTOMER_LIST_PARTIAL_DATA = SQLCommands.SELECT_CUSTOMER_LIST_PARTIAL_DATA;

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
	public CustomerViewRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Método que se encarga de recuperar todos los clientes de la vista
	 * "customer_list".
	 * 
	 * @return Lista de objetos {@link CustomerViewDTO} con la información de los
	 *         clientes.
	 */
	@Override
	public List<CustomerViewDTO> findAllCustomers() {
		List<CustomerViewDTO> customerList;
		try {
			customerList = jdbcTemplate.query(SELECT_CUSTOMER_LIST_PARTIAL_DATA, new CustomerViewRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		return customerList;
	}

}
