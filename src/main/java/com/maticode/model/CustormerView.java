package com.maticode.model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Prevent changes from being applied by Hibernate
@org.hibernate.annotations.Immutable
@Data
@Entity
@Table(name = "customer_list")
public class CustormerView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Nonnull
	@Column(name = "ID")
	private Long customerID;

	@Nonnull
	@Column(name = "name", length = 91)
	private String name;

	@Nonnull
	@Column(name = "address", length = 50)
	private String address;

	@Nonnull
	@Column(name = "zip code", length = 10)
	private String zipCode;

	@Nonnull
	@Column(name = "phone", length = 20)
	private String phone;

	@Nonnull
	@Column(name = "city", length = 50)
	private String city;

	@Nonnull
	@Column(name = "country", length = 50)
	private String country;

	@Nonnull
	@Column(name = "notes", length = 6)
	private String notes;

	@Nonnull
	@Column(name = "SID")
	private Long sid;

}
