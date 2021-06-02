package com.springboot.cityonlineassignmentbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cityonlineassignmentbackend.dto.MovieDto;
import com.springboot.cityonlineassignmentbackend.entity.Genre;
import com.springboot.cityonlineassignmentbackend.entity.Movie;
import com.springboot.cityonlineassignmentbackend.repository.GenreRepository;
import com.springboot.cityonlineassignmentbackend.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public List<MovieDto> findAll() { 
    	List<Movie> movies = movieRepository.findAll();
    	List<Genre> genres = genreRepository.findAll();
    	return MovieDto.valueOf(movies, genres);
    }

    public MovieDto create(Movie m) {
    	Movie movie = movieRepository.save(m);
    	return getMovieById(movie.getId());
    }
    
    public MovieDto update(String id, Movie updatedMovie) {
    	Movie oldMovie = movieRepository.getById(id);
    	oldMovie.update(updatedMovie);
    	movieRepository.save(oldMovie);
    	return getMovieById(id);
    }


    public MovieDto getMovieById(String id) {
    	if(id == null) { 
    	   return null; 
    	}
        Movie movie = movieRepository.getById(id);
        Genre genre = genreRepository.getById(movie.getGenreId());
    	return MovieDto.valueOf(movie, genre);
    }

}
