package com.example.main.service;

import com.example.main.models.movieDto.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@Service
public interface MovieService {

    ResponseEntity<?> getAllMovies();
    ResponseEntity<?> getMovieByID(int Id);

    ResponseEntity<?> addMovie(Movie movie);

    ResponseEntity<?> updateMovie(int id, Movie movie);

    ResponseEntity<?> deleteMovie(int id);
}
