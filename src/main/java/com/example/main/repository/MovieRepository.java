package com.example.main.repository;

import com.example.main.models.movieDto.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Optional<Movie> findById(int id);

}
