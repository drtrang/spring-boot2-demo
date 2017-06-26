package com.github.trang.springboot2.service;

import com.github.trang.springboot2.domain.User;
import com.github.trang.springboot2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author trang
 */
@Service
public class UserHandler {

    @Autowired
    private UserMapper userMapper;

    public Mono<ServerResponse> handleGetById(ServerRequest request) {
        return userMapper.getById(Long.valueOf(request.pathVariable("id")))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> handleListUsers(ServerRequest request) {
        return ServerResponse.ok().body(userMapper.list(), User.class);
    }

}