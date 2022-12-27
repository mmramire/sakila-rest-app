package com.maticode.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actor", schema = "sakila")
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "actor_id")
	private Long actorId;

	@Column(name = "first_name", length = 45, nullable = false, unique = false)
	private String firstName;

	@Column(name = "last_name", length = 45, nullable = false, unique = false)
	private String lastName;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	public Actor() {
		// Se crea porque internamente Spring usa proxy para crear constructor
		// Como definí abajo el constructor con párametros, debo ponerlo.
	}

	public Actor(String firstName, String lastName, Timestamp lastUpdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return actorId;
	}

	public void setId(Long id) {
		this.actorId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.sql.Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.sql.Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
