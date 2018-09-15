package com.sarang.moviewreviews.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sarang.moviewreviews.model.Movie;

@Repository
@Transactional
public class MoviesRepository {
	@Autowired
	private EntityManager em;

	public Movie findById(Long movieId) {
		return em.find(Movie.class, movieId);
	}

	public void deleteById(Long movieId) {
		Movie movies = findById(movieId);
		em.remove(movies);
	}

	public void save(Movie movie) {
		if (movie.getMovieId() == null) {
			// Insert
			em.persist(movie);
		} else {
			// Update
			em.merge(movie);
		}

	}

	public void playWithEntotyManager() {
		Movie movie1 = new Movie("Tiger Zinda Hai", "2017", "Detective xxx1", "Hindi", "/images/tzh_poster.jpeg");

		em.persist(movie1);
		em.flush();

		Movie movie2 = new Movie("Wanted", "2010", "Action xxx1", "Hindi", "/images/wanted_poster.jpeg");
		em.persist(movie2);
		em.flush();

		// em.detach(movie2);
		em.clear();

		movie1.setDescription("Detective Thriller zzz2");
		em.flush();

		movie2.setDescription("Action Drama zzz2");
		em.flush();

	}
}
