package com.maticode.customer_data_model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Prevent changes from being applied by Hibernate
@org.hibernate.annotations.Immutable
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

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "CustormerView [customerID=" + customerID + ", name=" + name + ", address=" + address + ", zipCode="
				+ zipCode + ", phone=" + phone + ", city=" + city + ", country=" + country + ", notes=" + notes
				+ ", sid=" + sid + "]";
	}

}
