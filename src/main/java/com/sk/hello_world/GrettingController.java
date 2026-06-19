package com.sk.hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World..";
    }
}
