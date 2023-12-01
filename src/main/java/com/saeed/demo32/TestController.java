package com.saeed.demo32;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String currentThread() {
        return Thread.currentThread().toString();
    }
}
