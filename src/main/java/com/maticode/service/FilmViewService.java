package com.maticode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.dtos.FilmViewDTO;
import com.maticode.repository.FilmViewRespositoryImpl;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FilmViewService {

	@Autowired
	FilmViewRespositoryImpl filmViewRepositoryImpl;

	public List<FilmViewDTO> listAll() {

		return filmViewRepositoryImpl.findAllFilms();

	}
}
