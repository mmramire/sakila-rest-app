package com.maticode.inventory_model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@Column(name = "film_id")
	private Integer filmId;
	private String title;
	private String description;
	@Column(name = "release_year")
	private Integer releaseYear;
	@Column(name = "language_id")
	private Integer languageId;
	@Column(name = "original_language_id")
	private Integer originalLanguageId;
	@Column(name = "rental_duration")
	private Integer rentalDuration;
	@Column(name = "rental_rate")
	private BigDecimal rentalRate;
	private Integer length;
	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;
	private Rating rating;
	@Column(name = "special_features")
	private String specialFeatures;
	@Column(name = "last_update")
	private Timestamp lastUpdate;

	public enum Rating {
		G, PG, PG_13, R, NC_17
	}

	// getters and setters
	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
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

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(Integer originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageId=" + languageId + ", originalLanguageId=" + originalLanguageId
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
