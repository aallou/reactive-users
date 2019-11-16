package com.aallou.spring.test.reactiveusers.utils;

import com.aallou.spring.test.reactiveusers.entities.User;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class LoaderData {

    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, User> userOperations;

    public LoaderData(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, User> userOperations) {
        this.factory = factory;
        this.userOperations = userOperations;
    }

    @PostConstruct
    public void loadData() {
        factory.getReactiveConnection().serverCommands().flushAll().thenMany(
                Flux.range(1, 1000)
                        .map(id -> new User(UUID.randomUUID().toString(), "User first name " + id, "User last name " + id))
                        .flatMap(user -> userOperations.opsForValue().set(user.getFirstName(), user)))
                .thenMany(userOperations.keys("*")
                        .flatMap(userOperations.opsForValue()::get))
                .subscribe(System.out::println);
    }
}
