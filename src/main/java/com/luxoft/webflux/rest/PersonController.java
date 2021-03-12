package com.luxoft.webflux.rest;

import com.luxoft.webflux.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.luxoft.webflux.domain.Person;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person")
    public Flux<Person> all() {
        return repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Mono<Person> byId(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    // TODO: POST /person

    // TODO: GET /person/find?name=Ivan
}
