package com.springboot.cityonlineassignmentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.cityonlineassignmentbackend.entity.Genre;


public interface GenreRepository extends
        JpaRepository<Genre, String>,
        JpaSpecificationExecutor<Genre> {
}