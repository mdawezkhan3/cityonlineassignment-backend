package com.springboot.cityonlineassignmentbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.cityonlineassignmentbackend.entity.Genre;
import com.springboot.cityonlineassignmentbackend.service.GenreService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*",allowCredentials = "true")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    
    @GetMapping(value = "/genres", produces = "application/json")
    public ResponseEntity<List<Genre>> getGenres(@RequestParam(required = false) String filter,
    		@RequestParam(required = false) String range) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        List<Genre> genres = new ArrayList<>();
        
        if(filter != null && filter.contains("autocomplete")) {
        	Genre genre = new Genre();
            genre.setId("-1");
            genre.setName("+ New");
            genres.add(genre);
        }
        
        genres.addAll(genreService.findAll());
        
        headers.set("Content-Range", "genres 0-" + (genres.size() - 1) + "/" + genres.size());
        return ResponseEntity
                .status(200)
                .headers(headers)
                .body(genres);
    }
    
    
    @PostMapping(value = "/genres", produces = "application/json")
    public Genre createGenre(@RequestBody Genre genre) throws IOException {
        return genreService.create(genre);
    }
    
    
    @PutMapping(value = "/genres/{id}", produces = "application/json")
    public Genre updateGenre(@PathVariable String id, @RequestBody Genre genre) throws IOException  {
        return genreService.update(id, genre);
    }

    
    @GetMapping(value = "/genres/{id}", produces = "application/json")
    public Genre getGenre(@PathVariable String id) throws IOException {
        return genreService.getGenreById(id);
    }

}
