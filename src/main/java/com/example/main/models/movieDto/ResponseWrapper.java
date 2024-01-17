package com.example.main.models.movieDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@Getter@Setter@ToString
public class ResponseWrapper {
    private int statusCode;
    private String description;
    private String statusMessage;
    private List<Movie> movies;
}
