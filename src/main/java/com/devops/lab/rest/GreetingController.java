package com.devops.lab.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcello.ozzetti on 14/07/22.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private String nula = null;

    @GetMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name")
                                         String name) {

        if(false){
            //Test to check Sonar Quality-Gate
            nula.toString();

        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
