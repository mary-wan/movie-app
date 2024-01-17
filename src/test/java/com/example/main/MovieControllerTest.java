//package com.example.main;
//
//import com.example.main.contoller.MovieController;
//import com.example.main.models.movieDto.Movie;
//import com.example.main.service.MovieService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Mary Njenga
// * KCB Group - BSS
// */
//@SpringBootTest
//public class MovieControllerTest {
//
//    @Mock
//    MovieService movieService;
//
//    @InjectMocks
//    MovieController movieController;
//
//    @Test
//    void getAllMoviesTest(){
//        Movie movie  = new Movie();
//        movie.setId(1);
//        movie.setTitle("New Movie");
//        List<Movie> movieList = new ArrayList<>();
//        movieList.add(movie);
//
//        Mockito.when(movieService.getAllMovies()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
//        movieController.getAllMovies();
//
//    }
//}
