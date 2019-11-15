package com.ljm.my.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //*@GetMapping(value = "/Hello/{name}")
    @RequestMapping(value = "/Hello/{name}")
    public String sayHi( @PathVariable String name) {
        return name+"Hello Spring Boot.";
    }
}
