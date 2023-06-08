package com.lychee.streamv.controller;

import com.lychee.streamv.domain.movie.Movie;
import com.lychee.streamv.domain.movie.MovieDTO;
import com.lychee.streamv.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/form")
    public String renderPageForm() {
        return "movies/form";
    }
    @GetMapping
    public String renderPageList(Model model) {
        model.addAttribute("list", repository.findAll());
        return "movies/list";
    }

    @PostMapping
    public String createMovie(MovieDTO movieDTO) {
        var movie = new Movie(movieDTO);
        repository.save(movie);
        System.out.println(movie);

        return "redirect:/movies";
    }
}
