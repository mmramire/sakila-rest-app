package com.maticode.inventory_model;

import java.util.Date;

import com.maticode.business_model.Store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory", schema = "sakila")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	private Film film;

	@ManyToOne
	@JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
	private Store store;

	@Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", film=" + film + ", lastUpdate=" + lastUpdate + "]";
	}

}
