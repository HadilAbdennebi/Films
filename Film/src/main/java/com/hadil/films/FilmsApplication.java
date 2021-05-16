package com.hadil.films;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hadil.films.entities.Film;
import com.hadil.films.service.FilmService;

@SpringBootApplication
public class FilmsApplication implements CommandLineRunner {
@Autowired
FilmService filmService;
	public static void main(String[] args) {
	SpringApplication.run(FilmsApplication.class, args);
	}
@Override
public void run(String... args) throws Exception {
	/*
	filmService.saveFilm(new Film("Frozen", 26000.0, new Date()));
	filmService.saveFilm(new Film("Titanic", 28000.0, new Date()));
	filmService.saveFilm(new Film("saw", 9000.0, new Date()));
	*/
}
}
