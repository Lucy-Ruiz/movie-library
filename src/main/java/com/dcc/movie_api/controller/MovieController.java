package com.dcc.movie_api.controller;

import com.dcc.movie_api.data.Movie;
import com.dcc.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @PutMapping("/updateMovie/{id}")
    public Movie updateMovie(@RequestBody Movie newMovie, @PathVariable Integer id){
        Movie movie = movieService.getById(id);

            movie.setName(newMovie.getName());
            movie.setGenre(newMovie.getGenre());
            movie.setDirector(newMovie.getDirector());
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteById(@PathVariable Integer id){
        movieService.deleteById(id);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movie findMovieById(@PathVariable Integer id){
        return movieService.getById(id);
    }
    @GetMapping("/findByGenre/{genre}")
    public List<Movie> findMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/findByName/{name}")
    public List<Movie> findMovieByName(@PathVariable String name){
        return movieService.getByName(name);
    }
}
