package com.dry.boot01.controller;

import com.dry.boot01.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/")
    public String hello(){
        return "Hello, this is SpringBoot2!";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
