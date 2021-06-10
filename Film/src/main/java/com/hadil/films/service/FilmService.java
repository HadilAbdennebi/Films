package com.hadil.films.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

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
	 
	 @Query("select f from Film f where f.idGenre = ?1")
	 List<Film> findByGenre (String genre);
	 List<Film> listAll(String key);
	 
	 List<Film> findByOrderByNomFilmAsc();
	 List<Film> trierFilmsNomsPrix();
}
