package com.springreactive.netfluxsample.controllers;

import com.springreactive.netfluxsample.domain.Movie;
import com.springreactive.netfluxsample.domain.MovieEvent;
import com.springreactive.netfluxsample.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvent(@PathVariable String id) {
        return movieService.events(id);
    }

    @GetMapping(value = "/{id}")
    Mono<Movie> findById(@PathVariable String id) {
        return movieService.getByMovieId(id);
    }


    @GetMapping
    Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

}
