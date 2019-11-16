package com.aallou.spring.test.reactiveusers.resources;

import com.aallou.spring.test.reactiveusers.dao.UserRepository;
import com.aallou.spring.test.reactiveusers.entities.User;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UsersController {

    UserRepository userRepository;

    UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getUsersStream() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public Mono<Void> save(@RequestBody User user) {
        return this.userRepository.save(user).then();
    }
}
