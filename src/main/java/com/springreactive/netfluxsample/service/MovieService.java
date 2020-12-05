package com.springreactive.netfluxsample.service;

import com.springreactive.netfluxsample.domain.Movie;
import com.springreactive.netfluxsample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Mono<Movie> getByMovieId(String id);

    Flux<Movie> getAllMovies();

}
