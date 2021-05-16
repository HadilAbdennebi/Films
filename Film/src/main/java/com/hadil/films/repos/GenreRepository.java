package com.hadil.films.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hadil.films.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	
	List<Genre> findByNomGenre(String nom);
	
	// @Query("select g from Genre g where g.nomGenre = ?2")
	 List<Genre> findByNomGenreContains(String nom);
	 
	

	 
}
