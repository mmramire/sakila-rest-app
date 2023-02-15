package com.maticode.repository;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maticode.dtos.FilmViewDTO;
import com.maticode.mapper.FilmViewRowMapper;
import com.maticode.queries.SQLCommands;

/**
 * Repositorio que se encarga de realizar operaciones de consulta a la vista
 * "film_list" o "nicer_but_slower_film_list" en la base de datos. Implementa la
 * interfaz {@link IFilmViewRespository}.
 * 
 * @author mmram
 * @since 15/02/2023
 */
@Repository
public class FilmViewRepositoryImpl implements IFilmViewRepository {

//	private static final String SELECT_FILM_LIST = SQLCommands.SELECT_FILM_LIST;
	private static final String SELECT_NICER_BUT_SLOWE_FILM_LIST = SQLCommands.SELECT_NICER_BUT_SLOWE_FILM_LIST;

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
	public FilmViewRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Método que se encarga de recuperar todos los films de la vista "film_list" o
	 * "nicer_but_slower_film_list" depende que parámetro se use.
	 * 
	 * @return Lista de objetos {@link FilmViewDTO} con la información de los films.
	 */
	@Override
	public List<FilmViewDTO> findAllFilms() {
		List<FilmViewDTO> filmList;
		try {
			filmList = jdbcTemplate.query(SELECT_NICER_BUT_SLOWE_FILM_LIST, new FilmViewRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		return filmList;
	}

}
