package com.maticode.customer_data_model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private short id;

	@NotBlank
	@Column(name = "address")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@NotBlank
	@Column(name = "district")
	private String district;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "postal_code")
	private String postalCode;

	@NotBlank
	@Column(name = "phone")
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;

	// Getters and setters
}
