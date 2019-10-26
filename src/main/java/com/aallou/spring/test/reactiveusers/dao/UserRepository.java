package com.aallou.spring.test.reactiveusers.dao;

import com.aallou.spring.test.reactiveusers.entities.User;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class UserRepository {


    private ReactiveRedisOperations<String, User> userOperations;

    UserRepository(ReactiveRedisOperations<String, User> userOperations) {
        this.userOperations = userOperations;
    }

    public Flux<User> findAll() {
        return this.userOperations.keys("*").flatMap(userOperations.opsForValue()::get);
    }

    public Mono<Boolean> save(User user) {
        user.setId(UUID.randomUUID().toString());
        return this.userOperations.opsForValue().set(user.getId(), user);
    }

}
