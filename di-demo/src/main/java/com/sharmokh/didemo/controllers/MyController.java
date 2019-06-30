package com.sharmokh.didemo.controllers;

import com.sharmokh.didemo.services.GreetingService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Controller
@Primary
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("Hello!!! ");
        return greetingService.sayGreeting();
    }
}
