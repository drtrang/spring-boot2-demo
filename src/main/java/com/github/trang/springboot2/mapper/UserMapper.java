package com.github.trang.springboot2.mapper;

import com.github.trang.springboot2.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author trang
 */
@Repository
public class UserMapper {

    private static final List<User> USERS = Arrays.asList(new User(1L, "trang"), new User(2L, "liang"));

    public Mono<User> getById(long id) {
        return Mono
                .justOrEmpty(USERS.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null));
    }

    public Flux<User> list() {
        return Flux.fromIterable(USERS);
    }

}
