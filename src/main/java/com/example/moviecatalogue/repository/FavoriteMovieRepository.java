package com.example.moviecatalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviecatalogue.model.FavoriteMovie;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {
}