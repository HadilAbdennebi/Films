package com.hadil.films.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;
import com.hadil.films.repos.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;

	@Override
	public Film saveFilm(Film f) {
		return filmRepository.save(f);
	}

	@Override
	public Film updateFilm(Film f) {
		return filmRepository.save(f);
	}

	@Override
	public void deleteFilm(Film f) {
		filmRepository.delete(f);
	}

	@Override
	public void deleteFilmById(Long id) {
		filmRepository.deleteById(id);
	}

	@Override
	public Film getFilm(Long id) {
		return filmRepository.findById(id).get();
	}

	@Override
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@Override
	public Page<Film> getAllFilmsParPage(int page, int size) {
		return filmRepository.findAll(PageRequest.of(page, size));	}

	@Override
	public List<Film> findByNomFilm(String nom) {
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return filmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomPrix(String nom, Double prix) {
		return filmRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return filmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmsNomsPrix() {
		return filmRepository.trierFilmsNomsPrix();
	}
/*
	@Override
	public List<Film> findByGenre(String keyword) {
		return filmRepository.findByGenreNomGenre(keyword);
	}*/
	@Override
	public List<Film> findByGenre(String genre) {
		return filmRepository.findByGenre(genre);
	}
	
	@Autowired
	private FilmRepository repo;
	
	public List<Film> listAll(String keyword) {
		if (keyword != null) {
			return repo.findAll(keyword);
		}
		return repo.findAll();
	}
}
