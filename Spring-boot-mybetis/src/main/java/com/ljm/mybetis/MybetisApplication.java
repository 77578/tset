package com.ljm.mybetis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ljm.mybetis.Dao")
public class MybetisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybetisApplication.class, args);
    }

}
