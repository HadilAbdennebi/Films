package com.hadil.films.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;

public interface FilmService {
	Film saveFilm(Film f);
	Film updateFilm(Film f);
	void deleteFilm(Film f);
	 void deleteFilmById(Long id);
	 Film getFilm(Long id);
	List<Film> getAllFilms();
	Page<Film> getAllFilmsParPage(int page, int size);

	List<Film> findByNomFilm(String nom);
	 List<Film> findByNomFilmContains(String nom);
	 List<Film> findByNomPrix (String nom, Double prix);
	// List<Film> findByGenre(String keyword);
	 List<Film> findByGenre (Genre genre);

	 
	 List<Film> findByOrderByNomFilmAsc();
	 List<Film> trierFilmsNomsPrix();
}
