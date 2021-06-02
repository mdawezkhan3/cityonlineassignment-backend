package com.springboot.cityonlineassignmentbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.cityonlineassignmentbackend.dto.MovieDto;
import com.springboot.cityonlineassignmentbackend.entity.Movie;
import com.springboot.cityonlineassignmentbackend.service.MovieService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*",allowCredentials = "true")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    
    @GetMapping(value = "/movies", produces = "application/json")
    public ResponseEntity<List<MovieDto>> getMovies(@RequestParam(required = false) String filter,
    		@RequestParam(required = false) String range) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        List<MovieDto> movies = movieService.findAll();
        
        headers.set("Content-Range", "movies 0-" + (movies.size() - 1) + "/" + movies.size());
        return ResponseEntity
                .status(200)
                .headers(headers)
                .body(movies);
    }
    
    
    @PostMapping(value = "/movies", produces = "application/json")
    public MovieDto createMovie(@RequestBody Movie movie) throws IOException {
        return movieService.create(movie);
    }
    
    
    @PutMapping(value = "/movies/{id}", produces = "application/json")
    public MovieDto updateMovie(@PathVariable String id, @RequestBody Movie movie) throws IOException  {
        return movieService.update(id, movie);
    }

    
    @GetMapping(value = "/movies/{id}", produces = "application/json")
    public MovieDto getMovie(@PathVariable String id) throws IOException {
        return movieService.getMovieById(id);
    }

}
