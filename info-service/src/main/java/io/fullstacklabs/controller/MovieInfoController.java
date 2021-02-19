package io.fullstacklabs.controller;

import io.fullstacklabs.model.Movie;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RefreshScope
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        return Movie.builder()
                .movieId(movieId)
                .name("Test Name")
                .build();
    }
}