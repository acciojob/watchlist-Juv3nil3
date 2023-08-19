package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void pairMovieWithDirector(String movieName, String directorName) {
        movieRepository.pairMovieWithDirector(movieName, directorName);
    }

    public Movie findMovieByName(String name) {
        return movieRepository.findMovieByName(name);
    }

    public Director findDirectorByName(String name) {
        return movieRepository.findDirectorByName(name);
    }

    public List<String> findMoviesByDirectorName(String directorName) {
        return movieRepository.findMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovieNames() {
        return movieRepository.findAllMovieNames();
    }

    public List<String> findAllDirectorNames() {
        return movieRepository.findAllDirectorNames();
    }

    public void deleteDirectorAndMovies(String directorName) {
        movieRepository.deleteDirectorAndMovies(directorName);
    }

    public void deleteAllDirectorsAndMovies() {
        movieRepository.deleteAllDirectorsAndMovies();
    }
}
