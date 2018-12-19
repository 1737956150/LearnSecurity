package com.zzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @classname DemoApplication
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/19 14:10
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @GetMapping("hello")
    public String helloSecurity(){
        return "Hello Secuity";
    }
}
