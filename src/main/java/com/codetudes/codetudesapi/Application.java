package com.codetudes.codetudesapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }

    @Autowired
    private Environment env;


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}