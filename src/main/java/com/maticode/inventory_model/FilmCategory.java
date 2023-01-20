package com.maticode.inventory_model;

import java.util.Date;
import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_category", schema = "sakila")
public class FilmCategory {
	@Id
	@Column(name = "film_id")
	private Long filmId;

	@Id
	@Column(name = "category_id")
	private Long categoryId;

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	private Film film;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private Category category;

	@Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date lastUpdate;

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "FilmCategory [filmId=" + filmId + ", categoryId=" + categoryId + ", film=" + film + ", category="
				+ category + ", lastUpdate=" + lastUpdate + "]";
	}

}
