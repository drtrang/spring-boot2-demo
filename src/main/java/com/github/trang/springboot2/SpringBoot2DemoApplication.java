package com.github.trang.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBoot2DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("project is running...");
    }

}