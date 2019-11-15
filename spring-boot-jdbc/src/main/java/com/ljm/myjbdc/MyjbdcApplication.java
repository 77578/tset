package com.ljm.myjbdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ljm.myjbdc.Controller","com.ljm.myjbdc.Dao","com.ljm.myjbdc.Service"})
public class MyjbdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyjbdcApplication.class, args);
    }

}
