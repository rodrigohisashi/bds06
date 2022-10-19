package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieAbbreviatedDTO;
import com.devsuperior.movieflix.dto.MovieAllDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.domain.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieAbbreviatedDTO>> findMovies(Pageable pageable, @RequestParam(value = "genreId", defaultValue = "") Long idGenre) {
        Page<MovieAbbreviatedDTO> page = service.findAllMovies(pageable, idGenre);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<MovieAllDetailsDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value="/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findReviews(id));
    }
}
