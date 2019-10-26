package com.aallou.spring.test.reactiveusers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    String id;
    String title;
    String year;
}
