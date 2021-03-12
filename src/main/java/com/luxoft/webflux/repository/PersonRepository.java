package com.luxoft.webflux.repository;

import com.luxoft.webflux.domain.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

    Flux<Person> findAll();

    Mono<Person> findById(String id);
}
