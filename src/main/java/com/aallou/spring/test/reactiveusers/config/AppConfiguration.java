package com.aallou.spring.test.reactiveusers.config;

import com.aallou.spring.test.reactiveusers.entities.Film;
import com.aallou.spring.test.reactiveusers.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class AppConfiguration {

    @Bean
    ReactiveRedisTemplate<String, User> reactiveRedisTemplateUser(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, User> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, User> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

    @Bean
    ReactiveRedisTemplate<String, Film> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Film> serializer = new Jackson2JsonRedisSerializer<>(Film.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Film> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Film> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
