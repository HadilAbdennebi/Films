package com.hadil.films.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;

public interface FilmRepository extends JpaRepository<Film, Long> {
		List<Film> findByNomFilm(String nom);
		 List<Film> findByNomFilmContains(String nom);
		 

		 @Query("select p from Film p where p.nomFilm like %:nom and p.prixTicket > :prix")
		 List<Film> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

		 //List<Film> findByGenre (String keyword);
		 List<Film> findByGenre (Genre genre);

		 List<Film> findByGenreNomGenre(String keyword);

		// @Query("select p from Film p where p.genre is like %?1%")
		 //List<Film> findByGenre (Genre genre);
		// List<Film> findByGenreIdGen(Long id);
		 List<Film> findByOrderByNomFilmAsc();
		 
		 @Query("select p from Film p order by p.nomFilm ASC, p.prixTicket DESC")
		 List<Film> trierFilmsNomsPrix ();
		 



}
