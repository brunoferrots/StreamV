package com.lychee.streamv.controller;

import com.lychee.streamv.domain.movie.Movie;
import com.lychee.streamv.domain.movie.MovieDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private List<Movie> movies = new ArrayList<>();

    @GetMapping("/form")
    public String renderPageForm() {
        return "movies/form";
    }
    @GetMapping
    public String renderPageList() {
        return "movies/list";
    }

    @PostMapping
    public String createMovie(MovieDTO movieDTO) {
        var movie = new Movie(movieDTO);
        movies.add(movie);
        System.out.println(movies);

        return "movies/form";
    }
}
