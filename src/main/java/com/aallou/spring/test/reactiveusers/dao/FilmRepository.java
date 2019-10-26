package com.aallou.spring.test.reactiveusers.dao;

import com.aallou.spring.test.reactiveusers.entities.Film;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FilmRepository extends ReactiveCrudRepository<Film, String> {
}
