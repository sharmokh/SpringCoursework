package com.sharmokh.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("es")
public class SpanishGreetingService implements GreetingService {

    private static final String HELLO = "Hola! Como estas?";

    @Override
    public String sayGreeting() {
        return HELLO;
    }

}
