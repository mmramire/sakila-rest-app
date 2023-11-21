package com.maticode.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maticode.dtos.ActorDTO;
import com.maticode.dtos.ActorSearchDTO;
import com.maticode.mapper.ActorRowMapper;
import com.maticode.mapper.BlobSizeRowMapper;

@Repository
public class ActorRepository {

	// Deje afuera la columna picture que es de tipo Blob
	private static final String QUERY_ALL_ACTORS_BY_POST = "SELECT actor_id, first_name, last_name, last_update "
			+ " FROM actor WHERE " + " ( first_name = :firstName OR first_name = '' OR first_name IS NULL) "
			+ " OR (last_name = :lastName OR last_name = '' OR last_name IS NULL) "
			+ " ORDER BY actor_id LIMIT :limit OFFSET :offset";
	private static final String QUERY_FIND_ACTOR_BY_ID = "SELECT actor_id, first_name, last_name, last_update FROM actor WHERE actor_id = :id";
	private static final String QUERY_FIND_BY_FIRST_NAME = "SELECT actor_id, first_name, last_name, last_update FROM actor WHERE UPPER(first_name) LIKE UPPER(?)";
	private static final String QUERY_FIND_BY_LAST_NAME = "SELECT actor_id, first_name, last_name, last_update FROM actor WHERE UPPER(last_name) LIKE UPPER(:lastName)";
	private static final String QUERY_DOWNLOAD_PICTURE = "SELECT picture FROM actor WHERE actor_id = :id";
	private static final String QUERY_GET_ALL = "SELECT actor_id, first_name, last_name, last_update FROM actor";
	private static final String QUERY_GET_ALL_ACTORS_BY_PAGES_ORDER_BY_ACTOR_ID = "SELECT actor_id, first_name, last_name, last_update FROM actor "
			+ "ORDER BY actor_id LIMIT ? OFFSET ?";
	private static final String QUERY_GET_BLOB_SIZE_BY_ID = "SELECT LENGTH(picture) FROM actor WHERE actor_id = ?";
	private static final String QUERY_GET_TOTAL_ACTORS = "SELECT COUNT(*) FROM actor";

	/**
	 * Inyección del objeto JdbcTemplate para acceder a la base de datos.
	 */
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Constructor para inicializar el objeto JdbcTemplate con un objeto DataSource.
	 *
	 * @param dataSource DataSource para acceder a la base de datos.
	 */
	public ActorRepository(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	/**
	 * Retorna el Actor de la tabla actor coincidentes con el id
	 * 
	 * @param id
	 * @return ActorDTO
	 */
	public ActorDTO findActorById(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		return (ActorDTO) namedParameterJdbcTemplate.query(QUERY_FIND_ACTOR_BY_ID, params, new ActorRowMapper());
	}

	/**
	 * Retorna el listado de actores de la tabla actor coincidentes con el name
	 * 
	 * @param name
	 * @return List<ActorDTO>
	 */
	public List<ActorDTO> findByFirstName(String firstName) {
//		 Los pasos de ejecución de la SELECT, se pueden expresar en una plantilla (template) de código en la que rellenar algunas variables. 
//		 Es lo que hace el código de JdbcTemplate, apoyándose en otras clases e interfaces.
//		 Estas variables son el SQL y el conversor del ResultSet, pero también los parámetros de la consulta. 
//		 Cuando sean necesarios, los proporcionaremos a query como tercer argumento en un array (formato varargs), respetando el orden en el que aparecen en la cadena con el SQL.
		return jdbcTemplate.query(QUERY_FIND_BY_FIRST_NAME, new ActorRowMapper(), firstName);
	}

	public List<ActorDTO> findByLastName(String lastName) {

//		La consulta es más legible. Además, trabajar con «?» es propenso a errores porque nos obliga a ir contando los parámetros para conocer su índice.
//		Otra ventaja namedParameterJdbcTemplate es la disponibilidad en NamedParameterJdbcTemplate de métodos que aceptan los objetos SQLParameterSource 
//		(BeanPropertySqlParameterSource y MapSqlParameterSource)
		Map<String, String> params = new HashMap<>();
		params.put("lastName", lastName);
		return namedParameterJdbcTemplate.query(QUERY_FIND_BY_LAST_NAME, params, new ActorRowMapper());
	}

	/*
	 * Método que descarga imagen de la columna picture de la tabla actor. No
	 * chequea que exista, para eso se usa el método getBlobSizeById
	 * 
	 * @param id
	 * 
	 * @return Resource
	 */
	public Resource downloadPicture(Long id) throws SQLException, IOException {

		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		Blob blobPicture = namedParameterJdbcTemplate.queryForObject(QUERY_DOWNLOAD_PICTURE, params, Blob.class);

		try (InputStream inputStream = blobPicture.getBinaryStream()) {
			return new InputStreamResource(inputStream);
		} catch (SQLException | IOException e) {
			throw e;
		} finally {
			if (blobPicture != null) {
				blobPicture.free(); // Liberar el Blob
			}
		}
	}

	/**
	 * Retorna la lista de actores ordenada por ID filtrada por las páginas
	 * solicitadas
	 * 
	 * @param pageable
	 * @return List<ActorDTO>
	 */
	public List<ActorDTO> getAllActorsByPages(Pageable pageable) {

		int limit = pageable.getPageSize();
		int offset = pageable.getPageNumber() * limit;
		return jdbcTemplate.query(QUERY_GET_ALL_ACTORS_BY_PAGES_ORDER_BY_ACTOR_ID, new ActorRowMapper(), limit, offset);
	}

	/**
	 * Retorna el listado de actores de la tabla actor
	 * 
	 * @return List<ActorDTO>
	 */
	public List<ActorDTO> getAll() {
//		La forma general de realizar una consulta SELECT con JDBCTemplate que devuelva una lista de objetos consiste en proporcionar a uno de sus métodos query 
//		una cadena con el SQL y una implementación de la interfaz funcional RowMapper. 
//		Su propósito es convertir o mapear cada elemento del ResultSet con los resultados de la consulta en el objeto que queramos. 
//		Si la consulta no tiene resultados, JdbcTemplate se responsabiliza de devolver una lista vacía.
		return jdbcTemplate.query(QUERY_GET_ALL, new ActorRowMapper());
	}

	/**
	 * Método que retorna la longitud en bytes del blob si existe, sino retorna
	 * null.
	 * 
	 * @param id
	 * @return Optional<Long>
	 */
	public Optional<Long> getBlobSizeById(Long id) {
		List<Long> result = jdbcTemplate.query(QUERY_GET_BLOB_SIZE_BY_ID, new BlobSizeRowMapper(), id);
		if (!result.isEmpty()) {
			return Optional.of(result.get(0));
		} else {
			return Optional.ofNullable(result.get(0));
		}
	}

	public Long getTotalActors() {
		return jdbcTemplate.queryForObject(QUERY_GET_TOTAL_ACTORS, Long.class);
	}

	public List<ActorDTO> allActorsByPost(ActorSearchDTO request, Pageable pageable) {
//		Long id = request.getActorId();
		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		int limit = pageable.getPageSize();
		int offset = pageable.getPageNumber() * limit;

		Map<String, Object> params = new HashMap<>();
//		params.put("id", id);
		params.put("firstName", firstName);
		params.put("lastName", lastName);
		params.put("limit", limit);
		params.put("offset", offset);

		List<ActorDTO> respuesta = namedParameterJdbcTemplate.query(QUERY_ALL_ACTORS_BY_POST, params,
				new ActorRowMapper());
		return respuesta;

	}
}
