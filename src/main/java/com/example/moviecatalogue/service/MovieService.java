package com.example.moviecatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogue.dto.MovieDTO;
import com.example.moviecatalogue.dto.MovieResponseDTO;
import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.repository.FavoriteMovieRepository;
@Service
public class MovieService {
    private final RestTemplate restTemplate;
    private final FavoriteMovieRepository favoriteMovieRepository;

    @Value("${tmdb.api.key}")
    private String apiKey;

    private static final String TMDB_BASE_URL = "https://api.themoviedb.org/3";

    public MovieService(RestTemplate restTemplate, FavoriteMovieRepository favoriteMovieRepository) {
        this.restTemplate = restTemplate;
        this.favoriteMovieRepository = favoriteMovieRepository;
    }

    public List<MovieDTO> getTrendingMovies() {
        String url = TMDB_BASE_URL + "/trending/movie/week?api_key=" + apiKey;
        MovieResponseDTO response = restTemplate.getForObject(url, MovieResponseDTO.class);
        return response != null ? response.getResults() : List.of();
    }

    public List<MovieDTO> searchMovies(String query) {
        String url = TMDB_BASE_URL + "/search/movie?api_key=" + apiKey + "&query=" + query;
        MovieResponseDTO response = restTemplate.getForObject(url, MovieResponseDTO.class);
        return response != null && response.getResults() != null ? response.getResults() : List.of();
    }

    public MovieDTO getMovieDetails(Long id) {
        String url = TMDB_BASE_URL + "/movie/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieDTO.class);
    }

    public void addFavorite(MovieDTO movieDTO) {
        FavoriteMovie favorite = new FavoriteMovie();
        favorite.setId(movieDTO.getId());
        favorite.setTitle(movieDTO.getTitle());
        favorite.setPosterPath(movieDTO.getPoster_path());
        favorite.setOverview(movieDTO.getOverview());
        favorite.setReleaseDate(movieDTO.getRelease_date());
        favorite.setRating(movieDTO.getVote_average());
        favoriteMovieRepository.save(favorite);
    }

    public void removeFavorite(Long id) {
        favoriteMovieRepository.deleteById(id);
    }

    public List<FavoriteMovie> getFavorites() {
        return favoriteMovieRepository.findAll();
    }
}