package com.springreactive.netfluxsample.bootstrap;

import com.springreactive.netfluxsample.domain.Movie;
import com.springreactive.netfluxsample.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
@AllArgsConstructor
public class Bootstrap {

    private final MovieRepository movieRepository;

    @PostConstruct
    public void run() throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the lambdas", "Harry potter 1"
                        , "Harry potter 2"
                        , "Harry potter 3"
                        , "Harry potter 4"
                        , "Harry potter 5"
                        , "Harry potter 6"
                        , "Harry potter 7")
                        .map(title -> new Movie(UUID.randomUUID().toString(), title))
                        .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });


    }
}
