package com.lychee.streamv.controller;

import com.lychee.streamv.domain.movie.Movie;
import com.lychee.streamv.domain.movie.MovieAlterDTO;
import com.lychee.streamv.domain.movie.MovieDTO;
import com.lychee.streamv.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/form")
    public String renderPageForm(Long id, Model model) {
        if(id != null) {
            var movie = repository.getReferenceById(id);
            model.addAttribute("movie", movie);
        }
        return "movies/form";
    }
    @GetMapping
    public String renderPageList(Model model) {
        model.addAttribute("list", repository.findAll());
        return "movies/list";
    }

    @PutMapping
    @Transactional
    public String alterMovie(MovieAlterDTO data) {
        var movie = repository.getReferenceById(data.id());
        movie.updateData(data);
        return "redirect:/movies";
    }

    @PostMapping
    @Transactional
    public String createMovie(MovieDTO movieDTO) {
        var movie = new Movie(movieDTO);
        repository.save(movie);
        System.out.println(movie);

        return "redirect:/movies";
    }

    @DeleteMapping
    @Transactional
    public String removeMovie(Long id) {
        System.out.println("Deleting movie...");
        repository.deleteById(id);
        return "redirect:/movies";
    }
}
