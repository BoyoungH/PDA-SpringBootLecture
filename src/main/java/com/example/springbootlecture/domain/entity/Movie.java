package com.example.springbootlecture.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

//@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {

    private  long id;
    private  String name;
    private  Integer productionYear;
    private LocalDateTime createAt;

}
