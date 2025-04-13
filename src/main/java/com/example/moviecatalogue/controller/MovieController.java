package com.example.moviecatalogue.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviecatalogue.dto.MovieDTO;
import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.service.MovieService;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<MovieDTO> movies = movieService.getTrendingMovies();
        model.addAttribute("movies", movies);
        return "movie-list";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String query, Model model) {
        List<MovieDTO> movies = movieService.searchMovies(query);
        model.addAttribute("movies", movies);
        model.addAttribute("query", query);
        return "movie-list";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        try {
            MovieDTO movie = movieService.getMovieDetails(id);
            if (movie == null || movie.getId() == null) {
                model.addAttribute("error", "Movie not found");
                return "error";
            }
            model.addAttribute("movie", movie);
            return "movie-details";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch movie details");
            return "error";
        }
    }

    @PostMapping("/favorite/add")
    public String addFavorite(@RequestParam Long id) {
        MovieDTO movie = movieService.getMovieDetails(id);
        if (movie != null) {
            movieService.addFavorite(movie);
        }
        return "redirect:/favorites";
    }

    @PostMapping("/favorite/remove")
    public String removeFavorite(@RequestParam Long id) {
        movieService.removeFavorite(id);
        return "redirect:/favorites";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        List<FavoriteMovie> favorites = movieService.getFavorites();
        model.addAttribute("favorites", favorites);
        return "favorites";
    }
}