package com.example.moviecatalogue.dto;

import java.util.List;

public class MovieResponseDTO {
    private List<MovieDTO> results;

    public List<MovieDTO> getResults() { return results; }
    public void setResults(List<MovieDTO> results) { this.results = results; }
}