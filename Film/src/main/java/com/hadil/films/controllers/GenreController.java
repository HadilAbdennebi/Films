package com.hadil.films.controllers;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.stereotype.Controller;
	import java.text.ParseException;
	import java.util.List;
	import javax.validation.Valid;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
import com.hadil.films.entities.Genre;
import com.hadil.films.service.GenreService;


@Controller
public class GenreController {
			@Autowired
			GenreService genreService;
			
			@RequestMapping("/showCreateGenre")
			public String showCreate(ModelMap modelMap) {
				modelMap.addAttribute("genre", new Genre());
				modelMap.addAttribute("mode", "new");
				return "formGenre";
			}
			@RequestMapping("/saveGenre")
			public String saveGenre(@Valid Genre genre, BindingResult bindingResult) {
				if (bindingResult.hasErrors())
					return "formGenre";

				genreService.saveGenre(genre);
				return "formGenre";
			}
			
			@RequestMapping("/ListeGenres")
			public String listeGenres(ModelMap modelMap,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "4") int size)
			{
				Page<Genre> genres = genreService.getAllGenresParPage(page, size);
				modelMap.addAttribute("genres", genres);
				 modelMap.addAttribute("pages", new int[genres.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
				return "listeGenres";

			}

			
			@RequestMapping("/supprimerGenre")
			public String supprimerGenre(@RequestParam("id") Long id,
			 ModelMap modelMap,
			 @RequestParam (name="page",defaultValue = "0") int page,
			 @RequestParam (name="size", defaultValue = "3") int size)
			{
				genreService.deleteGenreById(id);
			Page<Genre> genres = genreService.getAllGenresParPage(page,size);
					modelMap.addAttribute("genres", genres);
					modelMap.addAttribute("pages", new int[genres.getTotalPages()]);
					modelMap.addAttribute("currentPage", page);
					modelMap.addAttribute("size", size);
			return "listeGenres";
			}
			
			@RequestMapping("/modifierGenre")
			public String editerGenre(@RequestParam("id") Long id,ModelMap modelMap)
			{
				Genre g= genreService.getGenre(id);
			modelMap.addAttribute("genre", g);
			modelMap.addAttribute("mode", "edit");
			return "formGenre";
			}
			@RequestMapping("/updateGenre")
			public String updateGenre(@ModelAttribute("genre") Genre genre,
			 ModelMap modelMap) throws ParseException
			{
			 genreService.updateGenre(genre);
			 List<Genre> genres = genreService.getAllGenres();
			 modelMap.addAttribute("genres", genres);
			return "listeGenres";
			}

}
