package com.sarang.moviewreviews.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarang.moviewreviews.model.Movie;
import com.sarang.moviewreviews.pojos.StdMoviesRespObj;
import com.sarang.moviewreviews.pojos.StdMoviesRqstObj;
import com.sarang.moviewreviews.repository.MoviesJPARepository;

@RestController
@RequestMapping(path = "/movies")
public class MoviesController {

	private Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);

	@Autowired
	private MoviesJPARepository moviesJPARepository;

	@GetMapping(path = "/sayhello")
	public String sayHello() {
		return "Hello World !!";
	}

	// CREATE
	@PostMapping(path = "/create")
	public List<Movie> createMovies(@RequestBody StdMoviesRqstObj stdMoviesRqstObj) {
		List<Movie> movies = stdMoviesRqstObj.getDataObj();
		LOGGER.info("Going to save: {} ", movies);

		return moviesJPARepository.saveAll(movies);
	}

	// READ ALL
	@GetMapping()
	public StdMoviesRespObj getAllMovies() {
		List<Movie> allMovies = moviesJPARepository.findAll();
		LOGGER.info("Going to list all movies : {} ", allMovies);
		StdMoviesRespObj stdMoviesRespObj = new StdMoviesRespObj();

		if (allMovies == null || allMovies.size() == 0) {
			stdMoviesRespObj.setResultsObj(null);
			stdMoviesRespObj.setStatus(HttpStatus.NO_CONTENT);
			stdMoviesRespObj.setMessage("No records found.");
		} else {
			stdMoviesRespObj.setResultsObj(allMovies);
			stdMoviesRespObj.setStatus(HttpStatus.OK);
			stdMoviesRespObj.setMessage("All records found.");
		}
		return stdMoviesRespObj;
	}

	// READ based-on ID
	@GetMapping(path = "/{movieId}")
	public StdMoviesRespObj getMovieById(@PathVariable Long movieId) {
		Movie movie = moviesJPARepository.findById(movieId).get();
		LOGGER.info("Going to list movies for id: ", movieId, "{} ", movie);
		StdMoviesRespObj stdMoviesRespObj = new StdMoviesRespObj();

		stdMoviesRespObj.setResultsObj(Arrays.asList(movie));
		stdMoviesRespObj.setStatus(HttpStatus.OK);
		stdMoviesRespObj.setMessage("Records found for ID: " + movieId);

		return stdMoviesRespObj;
	}

	// UPDATE
	@PutMapping(path = "/update")
	public List<Movie> updateMovies(@RequestBody StdMoviesRqstObj stdMoviesRqstObj) {
		List<Movie> movies = stdMoviesRqstObj.getDataObj();
		List<Movie> moviesReturn =  new ArrayList<Movie>();
		LOGGER.info("Going to update: {} ", movies);
		for (Movie movie : movies) {
			movie.setEntryDate(moviesJPARepository.findById(movie.getMovieId()).get().getEntryDate());
			moviesReturn.add(moviesJPARepository.save(movie));
		}
		return movies;
	}

	// DELETE
	@DeleteMapping(path = "/{movieId}")
	public StdMoviesRespObj deleteMovieById(@PathVariable Long movieId) {
		Movie movie = moviesJPARepository.findById(movieId).get();
		StdMoviesRespObj stdMoviesRespObj = new StdMoviesRespObj();
		LOGGER.info("Going to delete movie with ID: ", movieId);
		if (movie != null) {
			moviesJPARepository.deleteById(movieId);
			stdMoviesRespObj.setStatus(HttpStatus.OK);
			stdMoviesRespObj.setMessage("Record deleted for ID: " + movieId);
		} else {
			stdMoviesRespObj.setStatus(HttpStatus.NO_CONTENT);
			stdMoviesRespObj.setMessage("No records found for ID: " + movieId);
		}

		return stdMoviesRespObj;
	}
}
