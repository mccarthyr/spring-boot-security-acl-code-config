package com.fireduptech.spring.rest.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class HeroApplication  {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run( HeroApplication.class, args );

        /*
        for ( String name: applicationContext.getBeanDefinitionNames() ) {
            System.out.println( name );
        }
        */
    }


    @RequestMapping("/")
    String home() {
	    return "Hello World!";
    }


}
