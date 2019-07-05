package com.sharmokh.didemo.services;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en" :
                return greetingRepository.getEnglishGreeting();
            case "es" :
                return greetingRepository.getSpanishGreeting();
            case "de" :
                return greetingRepository.getGermanGreeting();
            default:
                return greetingRepository.getEnglishGreeting();
        }
    }

}
