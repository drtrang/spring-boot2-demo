package com.github.trang.springboot2.configuration;

import com.github.trang.springboot2.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author trang
 */
@Configuration
public class Routes {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/api/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleListUsers)
                .and(route(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::handleGetById));
    }

}