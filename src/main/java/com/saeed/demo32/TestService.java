package com.saeed.demo32;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Observed(name = "doSomething", lowCardinalityKeyValues = {"locale", "en-US"})
    public void doSomething() {
        System.out.println("Starting business logic...");
        // Write business logic here
    }

}
