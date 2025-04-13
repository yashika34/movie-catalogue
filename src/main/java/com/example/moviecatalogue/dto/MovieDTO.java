package com.example.moviecatalogue.dto;

public class MovieDTO {
    private Long id;
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;
    private Double vote_average;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPoster_path() { return poster_path; }
    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }
    public String getRelease_date() { return release_date; }
    public void setRelease_date(String release_date) { this.release_date = release_date; }
    public Double getVote_average() { return vote_average; }
    public void setVote_average(Double vote_average) { this.vote_average = vote_average; }
}