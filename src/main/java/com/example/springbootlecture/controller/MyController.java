package com.example.springbootlecture.controller;


import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    private MyService myService;
    private MyConfig myConfig;


    @Autowired
    public MyController(MyService myService, MyConfig myConfig){
        this.myService = myService;
        this.myConfig = myConfig;
    }


}
