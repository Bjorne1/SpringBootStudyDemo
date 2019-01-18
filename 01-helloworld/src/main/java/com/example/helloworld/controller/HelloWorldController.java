package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/18
 */
@RestController
public class HelloWorldController {

    @GetMapping(value = "hello")
    public String get() {
        return "Hello World";
    }
}
