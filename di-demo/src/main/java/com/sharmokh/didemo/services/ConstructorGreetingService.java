package com.sharmokh.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {

    public static final String HELLO = "Constructor: Please to meet you!";

    @Override
    public String sayGreeting() {
        return HELLO;
    }

}
