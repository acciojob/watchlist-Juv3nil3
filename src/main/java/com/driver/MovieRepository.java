package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private Map<String, Movie> moviesMap = new HashMap<>();
    private Map<String, Director> directorsMap = new HashMap<>();

    public void addMovie(Movie movie) {
        moviesMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorsMap.put(director.getName(), director);
    }

    public void pairMovieWithDirector(String movieName, String directorName) {
        Movie movie = moviesMap.get(movieName);
        Director director = directorsMap.get(directorName);
        if (movie != null && director != null) {
            movie.setDirector(director);
        }
    }

    public Movie findMovieByName(String name) {
        return moviesMap.get(name);
    }

    public Director findDirectorByName(String name) {
        return directorsMap.get(name);
    }

    public List<String> findMoviesByDirectorName(String directorName) {
        List<String> movieNames = new ArrayList<>();
        for (Movie movie : moviesMap.values()) {
            if (movie.getDirector() != null && movie.getDirector().getName().equals(directorName)) {
                movieNames.add(movie.getName());
            }
        }
        return movieNames;
    }

    public List<String> findAllMovieNames() {
        return new ArrayList<>(moviesMap.keySet());
    }

    public List<String> findAllDirectorNames() {
        return new ArrayList<>(directorsMap.keySet());
    }

    public void deleteDirectorAndMovies(String directorName) {
        directorsMap.remove(directorName);
        moviesMap.values().removeIf(movie -> movie.getDirector() != null && movie.getDirector().getName().equals(directorName));
    }

    public void deleteAllDirectorsAndMovies() {
        directorsMap.clear();
        moviesMap.values().forEach(movie -> movie.setDirector(null));
    }
}
