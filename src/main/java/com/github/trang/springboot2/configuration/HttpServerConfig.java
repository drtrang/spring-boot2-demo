package com.github.trang.springboot2.configuration;

import io.netty.util.NetUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.ipc.netty.http.server.HttpServer;

/**
 * @author trang
 */
@Configuration
public class HttpServerConfig {

    @Value("${server.port:8080}")
    private Integer serverPort;

    @Bean
    public HttpServer httpServer(RouterFunction<?> routerFunction) {
        HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        HttpServer server = HttpServer.create(NetUtil.LOCALHOST4.getHostAddress(), serverPort);
        server.newHandler(adapter);
        return server;
    }

}