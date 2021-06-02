package com.springboot.cityonlineassignmentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.cityonlineassignmentbackend.entity.Movie;


public interface MovieRepository extends
        JpaRepository<Movie, String>,
        JpaSpecificationExecutor<Movie> {
}