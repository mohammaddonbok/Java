package com.human.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {
    public static void main(String[] args) {
        SpringApplication.run(HellohumanApplication.class, args);
    }
    @RequestMapping("/")
    public String ShowHuman(@RequestParam(value="q" ,required = false) String searchQuery) {
        if(searchQuery == null) {
            String s="Human";
            return "<h1>Hello "+s +"</h1>"+"\n"+"<h3>Welcome to spring boot</h3>";
        }
    else{
            return "<h1>Hello "+searchQuery+"</h1>"+"\n"+"<h3>Welcome to spring boot</h3>";
        }
    }

}
