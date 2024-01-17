//package com.example.main.configs;
//
//import com.example.main.models.movieDto.Movie;
//import com.example.main.repository.MovieRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//@RequiredArgsConstructor
//public class DataInsert {
//
//    private final MovieRepository movieRepository;
//
//    @PostConstruct
//    void insertData(){
//        Movie movie1 = Movie.builder()
//                .title("Movie 1")
//                .rating("3").build();
//        Movie movie2 = Movie.builder()
//                .title("Movie 2")
//                .rating("4").build();
//        Movie movie3 = Movie.builder()
//                .title("Movie 3")
//                .rating("5").build();
//
//        movieRepository.saveAll(List.of(movie1,movie2,movie3));
//    }
//}
