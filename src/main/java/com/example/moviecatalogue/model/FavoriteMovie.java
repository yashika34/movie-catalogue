package com.example.moviecatalogue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FavoriteMovie {
    @Id
    private Long id;
    private String title;
    private String posterPath;
    private String overview;
    private String releaseDate;
    private Double rating;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
}