package com.luxoft.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.luxoft.webflux.domain.Person;
import com.luxoft.webflux.repository.PersonRepository;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class Main {

    public static void main( String[] args ) {
        ApplicationContext context = SpringApplication.run( Main.class );
        PersonRepository repository = context.getBean( PersonRepository.class );
        repository.saveAll( Arrays.asList(
                new Person( "Pushkin", 22 ),
                new Person( "Lermontov", 22 ),
                new Person( "Tolstoy", 60 )
        ) ).subscribe( p -> System.out.println( p.getLastName() ) );
    }
}


