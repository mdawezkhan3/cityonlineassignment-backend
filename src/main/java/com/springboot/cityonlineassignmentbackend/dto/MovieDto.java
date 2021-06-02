package com.springboot.cityonlineassignmentbackend.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.cityonlineassignmentbackend.entity.Genre;
import com.springboot.cityonlineassignmentbackend.entity.Movie;


@Data
public class MovieDto {
	
	private String id;
	private String name;
	private String releaseYear;
	private String genreName;
	private String genreImageUrl;
	private String genreId;
	private String rating;
	private String imageUrl;
	
	public static List<MovieDto> valueOf(List<Movie> movies, List<Genre> genres) {
        return movies.stream().map(m -> {
        	MovieDto dto = new MovieDto();
        	dto.setId(m.getId());
        	dto.setGenreId(m.getGenreId());
        	Genre genre = genres.stream().filter(g -> g.getId()
                    .equals(dto.genreId)).findFirst().orElse(null);
            dto.setGenreName(genre != null ? genre.getName() : "");
            dto.setGenreImageUrl(genre != null ? genre.getImageUrl() : null);
            dto.setName(m.getName());
            dto.setReleaseYear(m.getReleaseYear());
            dto.setRating(m.getRating());
            dto.setImageUrl(m.getImageUrl());
            return dto;
        }).collect(Collectors.toList());
    }
	
	public static MovieDto valueOf(Movie movie, Genre genre) {

        	MovieDto dto = new MovieDto();
        	dto.setId(movie.getId());
        	dto.setGenreId(movie.getGenreId());
            dto.setGenreName(genre != null ? genre.getName() : null);
            dto.setGenreImageUrl(genre != null ? genre.getImageUrl() : null);
            dto.setName(movie.getName());
            dto.setReleaseYear(movie.getReleaseYear());
            dto.setRating(movie.getRating());
            dto.setImageUrl(movie.getImageUrl());
            return dto;
        
    }
}
