package com.maticode.inventory_model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_text", schema = "sakila")
public class FilmText {

	@Id
	@Column(name = "film_id")
	private Long filmId;

	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@Column(name = "description", length = 65535)
	private String description;

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FilmText [filmId=" + filmId + ", title=" + title + ", description=" + description + "]";
	}

}
