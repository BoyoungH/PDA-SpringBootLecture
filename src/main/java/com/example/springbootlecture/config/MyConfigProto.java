package com.example.springbootlecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
public class MyConfigProto {
    @Bean
    public void configProto(){

    }

}
