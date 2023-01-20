package com.maticode.business_model;

import java.time.LocalDateTime;

import com.maticode.customer_data_model.Customer;
import com.maticode.inventory_model.Inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rental_id")
	private int rentalId;

	@Column(name = "rental_date", nullable = false)
	private LocalDateTime rentalDate;

	@ManyToOne
	@JoinColumn(name = "inventory_id", nullable = false)
	private Inventory inventory;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "return_date")
	private LocalDateTime returnDate;

	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;

	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime lastUpdate;

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", rentalDate=" + rentalDate + ", customer=" + customer
				+ ", returnDate=" + returnDate + ", staff=" + staff + ", lastUpdate=" + lastUpdate + "]";
	}

}
