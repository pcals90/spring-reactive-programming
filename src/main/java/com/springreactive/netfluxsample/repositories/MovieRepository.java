package com.springreactive.netfluxsample.repositories;

import com.springreactive.netfluxsample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
