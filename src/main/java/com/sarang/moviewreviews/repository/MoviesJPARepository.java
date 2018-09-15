package com.sarang.moviewreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarang.moviewreviews.model.Movie;

@Repository
public interface MoviesJPARepository extends JpaRepository<Movie, Long> {

}
