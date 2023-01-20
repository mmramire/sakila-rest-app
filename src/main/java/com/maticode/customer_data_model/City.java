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

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private short id;

	@jakarta.validation.constraints.NotBlank
	@Column(name = "city")
	private String city;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;

	// Getters and setters
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", lastUpdate=" + lastUpdate + "]";
	}

}
