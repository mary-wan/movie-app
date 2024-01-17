package com.example.main.contoller;

import com.example.main.models.movieDto.Movie;
import com.example.main.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin(origins = "*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllMovies(){
        return  movieService.getAllMovies();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") int id){
        return  movieService.getMovieByID(id);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addMovie(@RequestBody @Valid Movie movie){
        return  movieService.addMovie(movie);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") int id,@RequestBody @Valid Movie movie){
        return  movieService.updateMovie(id,movie);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id){
        return  movieService.deleteMovie(id);
    }



}
