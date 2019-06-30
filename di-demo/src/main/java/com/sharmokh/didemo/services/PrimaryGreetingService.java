package com.sharmokh.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en", "default"})
public class PrimaryGreetingService implements GreetingService {

    public static final String HELLO = "Skyla: Me, Brush Teeth Me";

    @Override
    public String sayGreeting() {
        return HELLO;
    }

}
