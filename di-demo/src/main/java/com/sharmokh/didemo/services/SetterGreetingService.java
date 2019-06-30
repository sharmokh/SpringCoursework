package com.sharmokh.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService{

    public static final String HELLO = "Setter: Hello there!";

    @Override
    public String sayGreeting() {
        return HELLO;
    }

}
