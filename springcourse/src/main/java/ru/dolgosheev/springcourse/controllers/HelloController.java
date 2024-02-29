package ru.dolgosheev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
