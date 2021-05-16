	package com.hadil.films.service;

	import java.util.List;

	import org.springframework.data.domain.Page;

	import com.hadil.films.entities.Genre;
	
public interface GenreService {

		Genre saveGenre(Genre g);
		Genre updateGenre(Genre g);
		void deleteGenre(Genre g);
		 void deleteGenreById(Long id);
		Genre getGenre(Long id);
		List<Genre> getAllGenres();
		Page<Genre> getAllGenresParPage(int page, int size);

}
