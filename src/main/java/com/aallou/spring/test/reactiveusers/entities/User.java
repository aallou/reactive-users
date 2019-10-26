package com.aallou.spring.test.reactiveusers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String id;
    String firstName;
    String lastName;
}
