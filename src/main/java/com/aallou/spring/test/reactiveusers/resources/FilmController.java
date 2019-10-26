package com.aallou.spring.test.reactiveusers.resources;

import com.aallou.spring.test.reactiveusers.dao.FilmRepository;
import com.aallou.spring.test.reactiveusers.entities.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FilmController {

    FilmRepository filmRepository;

    FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/films")
    public Flux<Film> findAll() {
        return this.filmRepository.findAll();
    }

    @PostMapping("/films")
    public Mono<Void> save(@RequestBody Film film) {
        return this.filmRepository.save(film).then();
    }
}
