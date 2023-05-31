package com.lychee.streamv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String renderPageForm() {
        return "movies/form";
    }
}
