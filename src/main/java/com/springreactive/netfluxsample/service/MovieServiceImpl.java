package com.springreactive.netfluxsample.service;

import com.springreactive.netfluxsample.domain.Movie;
import com.springreactive.netfluxsample.domain.MovieEvent;
import com.springreactive.netfluxsample.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Flux<MovieEvent> events(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            System.out.println("GENERANDO");
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<Movie> getByMovieId(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
