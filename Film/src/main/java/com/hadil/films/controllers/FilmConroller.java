package com.hadil.films.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hadil.films.entities.Film;
import com.hadil.films.entities.Genre;
import com.hadil.films.service.FilmService;


@Controller
public class FilmConroller {
		@Autowired
		FilmService filmService;
		
		@RequestMapping("/showCreate")
		public String showCreate(ModelMap modelMap) {
			modelMap.addAttribute("film", new Film());
			modelMap.addAttribute("mode", "new");
			return "formFilm";
		}
		@RequestMapping("/saveFilm")
		public String saveFilm(@Valid Film film, BindingResult bindingResult) {
			if (bindingResult.hasErrors())
				return "formFilm";

			filmService.saveFilm(film);
			return "formFilm";
		}
		
		@RequestMapping("/ListeFilms")
		public String listeFilms(ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "4") int size)
		{
			Page<Film> films = filmService.getAllFilmsParPage(page, size);
			modelMap.addAttribute("films", films);
			
			 modelMap.addAttribute("pages", new int[films.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeFilms";

		}

		
		@RequestMapping("/supprimerFilm")
		public String supprimerFilm(@RequestParam("id") Long id,
		 ModelMap modelMap,
		 @RequestParam (name="page",defaultValue = "0") int page,
		 @RequestParam (name="size", defaultValue = "3") int size)
		{
		filmService.deleteFilmById(id);
		Page<Film> films = filmService.getAllFilmsParPage(page,size);
				modelMap.addAttribute("films", films);
				modelMap.addAttribute("pages", new int[films.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
		return "listeFilms";
		}
		
		@RequestMapping("/modifierFilm")
		public String editerFilm(@RequestParam("id") Long id,ModelMap modelMap)
		{
		Film p= filmService.getFilm(id);
		modelMap.addAttribute("film", p);
		modelMap.addAttribute("mode", "edit");
		return "formFilm";
		}
		
		@RequestMapping("/updateFilm")
		public String updateFilm(@ModelAttribute("film") Film film,
		@RequestParam("date") String date,
		 ModelMap modelMap) throws ParseException
		{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateSortie = dateformat.parse(String.valueOf(date));
		 film.setDateSortie(dateSortie);

		 filmService.updateFilm(film);
		 List<Film> films = filmService.getAllFilms();
		 modelMap.addAttribute("films", films);
		return "listeFilms";
		}
	
		@RequestMapping("/chercher")
		public String chercher(Model model, @Param("key") String key) {

			List<Film> list = filmService.listAll(key);
			model.addAttribute("list", list);
			model.addAttribute("titre", key);

			return "chercher";
		}
		
}
