package com.example.main.service.implementation;

import com.example.main.configs.TransactionStatusEnums;
import com.example.main.models.movieDto.Movie;
import com.example.main.models.movieDto.ResponseWrapper;
import com.example.main.repository.MovieRepository;
import com.example.main.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public ResponseEntity<?> getAllMovies() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            List<Movie> movieList = movieRepository.findAll();
            responseWrapper.setDescription(TransactionStatusEnums.SUCCESS.getMessage());
            responseWrapper.setStatusMessage(TransactionStatusEnums.SUCCESS.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.SUCCESS.getCode());
            responseWrapper.setMovies(movieList);


            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            responseWrapper.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getMovieByID(int id) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if(optionalMovie.isPresent()){
                responseWrapper.setDescription(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusMessage(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusCode(TransactionStatusEnums.SUCCESS.getCode());
                responseWrapper.setMovies(List.of(optionalMovie.get()));

            }else{
                responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
                responseWrapper.setStatusMessage("Movie not Found");
                responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            }
            return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            responseWrapper.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> addMovie(Movie movie) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            movieRepository.save(movie);
            responseWrapper.setDescription(TransactionStatusEnums.SUCCESS.getMessage());
            responseWrapper.setStatusMessage(TransactionStatusEnums.SUCCESS.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.SUCCESS.getCode());
            responseWrapper.setMovies(List.of(movie));
            return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            responseWrapper.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> updateMovie(int id, Movie movie) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if(optionalMovie.isPresent()){
                Movie movie_ = optionalMovie.get();
                movie_.setTitle(movie.getTitle());
                movie_.setRating(movie.getRating());
                movieRepository.save(movie_);
                responseWrapper.setDescription(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusMessage(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusCode(TransactionStatusEnums.SUCCESS.getCode());
                responseWrapper.setMovies(List.of(movie_));

            }else{
                responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
                responseWrapper.setStatusMessage("Movie not Found");
                responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            }
            return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            responseWrapper.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> deleteMovie(int id) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if(optionalMovie.isPresent()){
                movieRepository.delete(optionalMovie.get());
                responseWrapper.setDescription(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusMessage(TransactionStatusEnums.SUCCESS.getMessage());
                responseWrapper.setStatusCode(TransactionStatusEnums.SUCCESS.getCode());
            }else{
                responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
                responseWrapper.setStatusMessage("Movie not Found");
                responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            }
            return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            responseWrapper.setDescription(TransactionStatusEnums.FAILURE.getMessage());
            responseWrapper.setStatusCode(TransactionStatusEnums.FAILURE.getCode());
            responseWrapper.setStatusMessage(e.getMessage());
            return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        }
    }
}
