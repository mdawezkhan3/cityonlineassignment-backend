package com.springboot.cityonlineassignmentbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.cityonlineassignmentbackend.entity.Genre;
import com.springboot.cityonlineassignmentbackend.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll() { 
    	return  genreRepository.findAll();
    }

    public List<Genre> findByIds(List<String> ids) {
        return genreRepository.findAllById(ids);
    }

    public Genre create(Genre r) { 
    	return genreRepository.save(r); 
    }
    
    public Genre update(String id, Genre updatedGenre) { 
    	Genre oldGenre = genreRepository.getById(id);
    	oldGenre.update(updatedGenre);
    	return genreRepository.save(oldGenre);
    }


    public Genre getGenreById(String id) {
    	if(id == null) { 
    	   return null; 
    	}
        return genreRepository.findById(id).orElse(null);
    }

}
