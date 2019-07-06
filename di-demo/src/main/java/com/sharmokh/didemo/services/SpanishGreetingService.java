package com.sharmokh.didemo.services;

public class SpanishGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public SpanishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}