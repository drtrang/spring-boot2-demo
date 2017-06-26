package com.github.trang.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author trang
 */
@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;

}