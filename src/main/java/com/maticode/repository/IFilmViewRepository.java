package com.maticode.repository;

import java.util.List;

import com.maticode.dtos.FilmViewDTO;

public interface IFilmViewRepository {
	List<FilmViewDTO> findAllFilms();
}
