package com.maticode.inventory_model;

import java.util.Date;

import com.maticode.customer_data_model.Actor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_actor", schema = "sakila")
public class FilmActor {
	@Id
	@Column(name = "actor_id")
	private Long actorId;

	@Id
	@Column(name = "film_id")
	private Long filmId;

	@ManyToOne
	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
	private Actor actor;

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	private Film film;

	@Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date lastUpdate;

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "FilmActor [actorId=" + actorId + ", filmId=" + filmId + ", actor=" + actor + ", film=" + film
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
