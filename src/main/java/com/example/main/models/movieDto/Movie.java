package com.example.main.models.movieDto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@Entity
@Table(name = "MOVIES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String rating;

}
