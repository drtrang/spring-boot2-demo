package com.github.trang.springboot2.test;

import com.github.trang.springboot2.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Slf4j
public class SpringBoot2DemoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void test() {
        FluxExchangeResult<User> result = webTestClient.get()
                .uri("/api/user")
                .accept(APPLICATION_JSON)
                .exchange()
                .returnResult(User.class);
        log.info("{}", result);
        List<User> users = result.getResponseBody().collectList().block();
        log.info("{}", result);
        log.info("{}", users);
    }

    @Test
    public void test1() {
        FluxExchangeResult<User> result = webTestClient.get()
                .uri("/api/user/1")
                .accept(APPLICATION_JSON)
                .exchange()
                .returnResult(User.class);
        log.info("{}", result);
        User user = result.getResponseBody().blockFirst();
        log.info("{}", result);
        log.info("{}", user);
    }

    @Test
    public void test2() {
        webTestClient.get()
                .uri("/api/user/10")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

}